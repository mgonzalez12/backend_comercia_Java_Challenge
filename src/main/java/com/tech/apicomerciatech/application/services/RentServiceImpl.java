package com.tech.apicomerciatech.application.services;

import com.tech.apicomerciatech.application.mapper.GameBboMapper;
import com.tech.apicomerciatech.application.services.utlis.RentBuilder;
import com.tech.apicomerciatech.application.usecases.ClientService;
import com.tech.apicomerciatech.application.usecases.GameService;
import com.tech.apicomerciatech.application.usecases.RentService;
import com.tech.apicomerciatech.application.services.utlis.BuildRentalReturnResponses;
import com.tech.apicomerciatech.application.services.utlis.BuildRentalsResponses;
import com.tech.apicomerciatech.application.services.utlis.Calculos;
import com.tech.apicomerciatech.domain.port.RentPersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import com.tech.apicomerciatech.infrastruture.adapter.enums.TipoJuego;
import org.openapitools.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import static com.tech.apicomerciatech.domain.constant.MessageContant.*;

@Service
@Transactional
public class RentServiceImpl implements RentService {

    private final RentPersistencePort rentPersistencePort;
    private final GameService gameService;
    private final GameBboMapper gameBboMapper;
    private final ClientService clientService;


    public RentServiceImpl(RentPersistencePort rentPersistencePort, GameService gameService, GameBboMapper gameBboMapper, ClientService clientService) {
        this.rentPersistencePort = rentPersistencePort;
        this.gameService = gameService;
        this.gameBboMapper = gameBboMapper;
        this.clientService = clientService;
    }
    @Override
    public RentalsResponse rentGames(RentalsGamesItem rentalsGamesItem) {
        Game gameEntity = Optional.ofNullable(gameService.findById(rentalsGamesItem.getIdJuego()))
                .orElseThrow(() -> new IllegalArgumentException(GAME_ID_MESSAGE + rentalsGamesItem.getIdJuego() + NO_ENCONTRADO_MESSAGE));
        Games game = gameBboMapper.toDto(gameEntity);

        BigDecimal basePrice = BigDecimal.valueOf(Calculos.calculateBasePrice(game));
        double totalPrice = Calculos.calculateTotalPrice(rentalsGamesItem.getDiasAlquilado(), basePrice, game);

        RentBuilder rentBuilder = new RentBuilder();
        Rent rent = rentBuilder.buildRent(rentalsGamesItem, game, totalPrice);

        ClientSearch client = Optional.ofNullable(clientService.findById(rent.getCliente().getId()))
                .orElseThrow(() -> new IllegalArgumentException(CLIENTE_ID_MESSAGE + rentalsGamesItem.getIdCliente() + NO_ENCONTRADO_MESSAGE));
        client.setLoyaltyPoints(client.getLoyaltyPoints() + (game.getType() == TipoJuego.NEW_RELEASE ? 2 : 1));

        rent = rentPersistencePort.save(rent);
        clientService.saveClienteSearch(client);

        BuildRentalsResponses builder = new BuildRentalsResponses();
        RentalsResponse rentResponse = builder.buildRentalsResponse(rent);
        return rentResponse;
    }

    @Override
    public ResponseEntity<RentalReturnResponse> rentalsReturnPost(RentalReturnRequest rentalReturnRequest) {
        return Optional.ofNullable(rentPersistencePort.findById(rentalReturnRequest.getIdAlquiler()))
                .map(rent -> {
                    int diasAlquiladosReales = (int) ChronoUnit.DAYS.between(rent.getFechaInicio(), LocalDate.now());
                    int diasExtra = diasAlquiladosReales - rent.getDiasAlquiladosSolicitados();
                    double recargo = diasExtra > 0 ? (diasExtra == 1 ? 3 : diasExtra * 4) : 0;

                    rent.setFechaFin(Date.valueOf(LocalDate.now()).toLocalDate());
                    rent.setDiasAlquiladosReales(diasAlquiladosReales);
                    rent.setRecargoRetraso(recargo);

                    rent = rentPersistencePort.save(rent);
                    ClientSearch client = clientService.findById(rent.getCliente().getId());

                    double preciosRecargoTotal = rent.getPrecioTotal() + rent.getRecargoRetraso();

                    BuildRentalReturnResponses builder = new BuildRentalReturnResponses();
                    RentalReturnResponse rentalReturnResponse =
                            builder.buildRentalReturnResponse(rent, client, recargo, preciosRecargoTotal);
                    return ResponseEntity.ok(rentalReturnResponse);
                })
                .orElseThrow(() ->
                        new IllegalArgumentException(RENT_ID_MESSAGE
                                + rentalReturnRequest.getIdAlquiler() + NO_ENCONTRADO_MESSAGE));
    }

    @Override
    public List<Rent> findByClientId(Long clientId) {
        return rentPersistencePort.findByClientId(clientId);
    }

}
