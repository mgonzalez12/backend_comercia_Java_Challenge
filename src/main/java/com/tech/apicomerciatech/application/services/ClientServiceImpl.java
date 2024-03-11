package com.tech.apicomerciatech.application.services;

import com.tech.apicomerciatech.application.mapper.ClientDboMapper;
import com.tech.apicomerciatech.application.mapper.ClientSearchDboMapper;
import com.tech.apicomerciatech.application.mapper.RentalsListResponseMapper;
import com.tech.apicomerciatech.application.usecases.ClientService;
import com.tech.apicomerciatech.domain.port.ClientPersistencePort;
import com.tech.apicomerciatech.domain.port.RentPersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import com.tech.apicomerciatech.infrastruture.adapter.exception.ClientNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.ClientSearch;
import org.openapitools.model.RentalsListResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientDboMapper clientDboMapper;
    private final ClientSearchDboMapper clientSearchDboMapper;
    private final ClientPersistencePort clientPersistencePort;
    private final RentPersistencePort rentPersistencePort;
    private final RentalsListResponseMapper rentalsResponseMapper;

    public ClientServiceImpl(ClientDboMapper clientDboMapper, ClientSearchDboMapper clientSearchDboMapper, ClientPersistencePort clientPersistencePort, RentPersistencePort rentPersistencePort, RentalsListResponseMapper rentalsResponseMapper) {
        this.clientDboMapper = clientDboMapper;
        this.clientSearchDboMapper = clientSearchDboMapper;
        this.clientPersistencePort = clientPersistencePort;
        this.rentPersistencePort = rentPersistencePort;
        this.rentalsResponseMapper = rentalsResponseMapper;
    }

    @Override
    public ClientCreate save(ClientCreate create) {
        Client client = clientDboMapper.toEntity(create);
        client.setLoyaltyPoints(0);
        client = clientPersistencePort.saveClient(client);
        return clientDboMapper.toDbo(client);
    }

    @Override
    public ClientSearch findById(Long id) {
        try {
            Client client = clientPersistencePort.findById(id);
            ClientSearch response = clientSearchDboMapper.toDbo(client);
            List<Rent> rentals = rentPersistencePort.findByClientId(id);
            List<RentalsListResponse> rentalResponses =
                    rentals.stream().map(rental -> rentalsResponseMapper.toDto(rental)).collect(Collectors.toList());
            response.setRentals(rentalResponses);
            return response;
        } catch (EntityNotFoundException e) {
            throw new ClientNotFoundException();
        }
    }

    @Override
    public ClientSearch saveClienteSearch(ClientSearch update) {
        Client client = clientSearchDboMapper.toEntity(update);
        client = clientPersistencePort.saveClient(client);
        return clientSearchDboMapper.toDbo(client);
    }
}
