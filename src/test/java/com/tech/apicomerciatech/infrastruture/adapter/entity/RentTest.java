package com.tech.apicomerciatech.infrastruture.adapter.entity;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class RentTest {

    @Test
    void testRent() {
        Rent rent = new Rent();
        rent.setId(1L);
        rent.setCliente(new Client(1L));
        rent.setJuego(new Games());
        rent.setDiasAlquiladosSolicitados(5);
        rent.setDiasAlquiladosReales(5);
        rent.setFechaInicio(LocalDate.now());
        rent.setFechaFin(LocalDate.now().plusDays(5));
        rent.setPrecioTotal(100.0);
        rent.setRecargoRetraso(10.0);
        assertAll(
                () -> assertEquals(1L, rent.getId()),
                () -> assertEquals(1L, rent.getCliente().getId()),
                () -> assertEquals(5, rent.getDiasAlquiladosSolicitados()),
                () -> assertEquals(5, rent.getDiasAlquiladosReales()),
                () -> assertEquals(100.0, rent.getPrecioTotal()),
                () -> assertEquals(10.0, rent.getRecargoRetraso())
        );
    }

}