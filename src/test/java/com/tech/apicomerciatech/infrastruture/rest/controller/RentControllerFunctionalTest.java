package com.tech.apicomerciatech.infrastruture.rest.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.tech.apicomerciatech.application.usecases.RentService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalReturnResponse;
import org.openapitools.model.RentalsGamesItem;
import org.openapitools.model.RentalsResponse;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class RentControllerFunctionalTest {
    @Mock
    private RentService rentService;

    @InjectMocks
    private RentController rentController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() { mockMvc = MockMvcBuilders.standaloneSetup(rentController).build(); }

    @Test
    void testRentalsRentPost() throws Exception {
        String rentalsGamesItemJson = "{\"idCliente\":1,\"idJuego\":1,\"diasAlquilado\":5,\"fechaInicio\":\"2024-03-11\"}"; // Asume que RentalsGamesItem tiene estos campos
        RentalsResponse rentalsResponse = new RentalsResponse(); // Asume que RentalsResponse es una clase válida

        Mockito.when(rentService.rentGames(Mockito.any(RentalsGamesItem.class))).thenReturn(rentalsResponse);

        mockMvc.perform(post("/api/rentals/rent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(rentalsGamesItemJson))
                .andExpect(status().isOk());
    }

    @Test
    void testRentalsReturnPost() throws Exception {
        String rentalReturnRequestJson = "{\"idAlquiler\":1}";
        RentalReturnResponse rentalReturnResponse = new RentalReturnResponse();

        Mockito.when(rentService.rentalsReturnPost(Mockito.any(RentalReturnRequest.class)))
                .thenReturn(ResponseEntity.ok(rentalReturnResponse));

        mockMvc.perform(post("/api/rentals/return")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(rentalReturnRequestJson))
                .andExpect(status().isOk());
    }
}
