package com.tech.apicomerciatech.infrastruture.rest.controller;

import org.junit.jupiter.api.Test;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalReturnResponse;
import org.openapitools.model.RentalsGamesItem;
import org.openapitools.model.RentalsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RentControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testRentalsRentPost() {
        RentalsGamesItem rentalsGamesItem = new RentalsGamesItem();
        rentalsGamesItem.setIdCliente(1L);
        rentalsGamesItem.setIdJuego(1L);
        rentalsGamesItem.setDiasAlquilado(5);
        rentalsGamesItem.setFechaInicio(LocalDate.parse("2024-03-11"));

        ResponseEntity<RentalsResponse> response =
                restTemplate.postForEntity("http://localhost:" + port + "/api/rentals/rent",
                        rentalsGamesItem, RentalsResponse.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testRentalsReturnPost() {
        RentalReturnRequest rentalReturnRequest = new RentalReturnRequest();
        rentalReturnRequest.setIdAlquiler(1L);

        ResponseEntity<RentalReturnResponse> response =
                restTemplate.postForEntity("http://localhost:" + port + "/api/rentals/return",
                        rentalReturnRequest, RentalReturnResponse.class);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}


