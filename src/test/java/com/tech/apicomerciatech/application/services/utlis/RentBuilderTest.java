package com.tech.apicomerciatech.application.services.utlis;

import static org.junit.jupiter.api.Assertions.*;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openapitools.model.RentalsGamesItem;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RentBuilderTest {

    @Test
    @DisplayName("Test Build Rent")
    void testBuildRent() {
        RentBuilder rentBuilder = new RentBuilder();
        RentalsGamesItem rentalsGamesItem = new RentalsGamesItem();
        rentalsGamesItem.setIdCliente(1L);
        rentalsGamesItem.setDiasAlquilado(5);
        rentalsGamesItem.setFechaInicio(LocalDate.now());

        Games game = new Games();
        game.setId(1L);
        double totalPrice = 100.0;
        Rent result = rentBuilder.buildRent(rentalsGamesItem, game, totalPrice);
        assertAll(
                () -> assertEquals(rentalsGamesItem.getIdCliente(), result.getCliente().getId()),
                ()-> assertEquals(game, result.getJuego()),
                ()-> assertEquals(rentalsGamesItem.getDiasAlquilado(), result.getDiasAlquiladosSolicitados()),
                ()-> assertEquals(rentalsGamesItem.getFechaInicio(), result.getFechaInicio()),
                ()-> assertEquals(totalPrice, result.getPrecioTotal()),
                ()-> assertEquals(0.0, result.getRecargoRetraso()),
                ()-> assertEquals(null, result.getFechaFin())
        );
    }
}
