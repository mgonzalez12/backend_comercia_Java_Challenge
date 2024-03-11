package com.tech.apicomerciatech.application.services.utlis;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.openapitools.model.RentalsGamesItem;

public class RentBuilder {
    public Rent buildRent(RentalsGamesItem rentalsGamesItem, Games game, double totalPrice) {
        Rent rent = new Rent();
        rent.setCliente(new Client(rentalsGamesItem.getIdCliente()));
        rent.setJuego(game);
        rent.setDiasAlquiladosSolicitados(rentalsGamesItem.getDiasAlquilado());
        rent.setFechaInicio(rentalsGamesItem.getFechaInicio());
        rent.setPrecioTotal(totalPrice);
        rent.setRecargoRetraso((double) 0);
        rent.setFechaFin(null);
        return rent;
    }
}
