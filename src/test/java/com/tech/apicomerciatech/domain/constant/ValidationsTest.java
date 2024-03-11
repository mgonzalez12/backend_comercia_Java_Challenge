package com.tech.apicomerciatech.domain.constant;

import org.junit.jupiter.api.Test;
import org.openapitools.model.ClientCreate;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalsGamesItem;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ValidationsTest {

    @Test
    void testValidateRentalsRequest() {
        Validations validations = new Validations();
        RentalsGamesItem rentalsGamesItem = new RentalsGamesItem();
        assertThrows(IllegalArgumentException.class, () -> validations.validateRentalsRequest(rentalsGamesItem));
        rentalsGamesItem.setIdJuego(1L);
        rentalsGamesItem.setDiasAlquilado(1);
        rentalsGamesItem.setFechaInicio(LocalDate.now());
        assertThrows(IllegalArgumentException.class, () -> validations.validateRentalsRequest(rentalsGamesItem));
        rentalsGamesItem.setIdCliente(1L);
        rentalsGamesItem.setIdJuego(null);
        assertThrows(IllegalArgumentException.class, () -> validations.validateRentalsRequest(rentalsGamesItem));
        rentalsGamesItem.setIdJuego(1L);
        rentalsGamesItem.setDiasAlquilado(null);
        assertThrows(IllegalArgumentException.class, () -> validations.validateRentalsRequest(rentalsGamesItem));
        rentalsGamesItem.setDiasAlquilado(1);
        rentalsGamesItem.setFechaInicio(null);
        assertThrows(IllegalArgumentException.class, () -> validations.validateRentalsRequest(rentalsGamesItem));
    }

    @Test
    void testValidateRentalReturnRequest() {
        Validations validations = new Validations();
        RentalReturnRequest rentalReturnRequest = new RentalReturnRequest();
        assertThrows(IllegalArgumentException.class, () -> validations.validateRentalReturnRequest(rentalReturnRequest));
        rentalReturnRequest.setIdAlquiler(1L);
        validations.validateRentalReturnRequest(rentalReturnRequest);
    }

    @Test
    void testValidateClientRequest() {
        Validations validations = new Validations();
        ClientCreate clientCreate = new ClientCreate();
        assertThrows(IllegalArgumentException.class, () -> validations.validateClientRequest(clientCreate));
        clientCreate.setName("Test");
        validations.validateClientRequest(clientCreate);
    }
}
