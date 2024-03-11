package com.tech.apicomerciatech.application.services.utlis;

import static org.junit.jupiter.api.Assertions.*;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Client;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openapitools.model.RentalsResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildRentalsResponsesTest {

    @Test
    @DisplayName("Test Build Rental Response")
    void testBuildRentalsResponse() {
        BuildRentalsResponses buildRentalsResponses = new BuildRentalsResponses();
        Rent rent = new Rent();
        rent.setId(1L);
        rent.setDiasAlquiladosSolicitados(5);
        rent.setFechaInicio(LocalDate.now());
        rent.setPrecioTotal(100.0);
        rent.setRecargoRetraso(10.0);
        Client cliente = new Client();
        cliente.setId(1L);
        rent.setCliente(cliente);
        Games juego = new Games();
        juego.setId(1L);
        rent.setJuego(juego);

        RentalsResponse result = buildRentalsResponses.buildRentalsResponse(rent);
        assertAll(
                () -> assertEquals(rent.getId(), result.getId()),
                ()-> assertEquals(rent.getCliente().getId(), result.getIdCliente()),
                ()-> assertEquals(rent.getJuego().getId(), result.getIdJuego()),
                ()-> assertEquals(rent.getDiasAlquiladosSolicitados(), result.getDiasAlquilado()),
                ()-> assertEquals(rent.getFechaInicio(), result.getFechaInicio()),
                ()-> assertEquals(BigDecimal.valueOf(rent.getPrecioTotal()), result.getPrecioTotal()),
                ()-> assertEquals(BigDecimal.valueOf(rent.getRecargoRetraso()), result.getRecargoRetraso()),
                ()-> assertEquals(BigDecimal.valueOf(rent.getRecargoRetraso())
                        .add(BigDecimal.valueOf(rent.getPrecioTotal())), result.getPriceTotalRecargos())
        );
    }
}
