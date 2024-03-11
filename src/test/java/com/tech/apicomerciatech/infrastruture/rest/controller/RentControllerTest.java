package com.tech.apicomerciatech.infrastruture.rest.controller;

import com.tech.apicomerciatech.application.usecases.RentService;
import com.tech.apicomerciatech.domain.constant.Validations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalReturnResponse;
import org.openapitools.model.RentalsGamesItem;
import org.openapitools.model.RentalsResponse;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class RentControllerTest {

    @InjectMocks
    RentController rentController;

    @Mock
    RentService rentService;

    @Mock
    Validations validations;

    @BeforeEach
    void setUp() { MockitoAnnotations.openMocks(this); }

    @Test
    @DisplayName("Test Rentals Rent Post - status 200")
    void testRentalsRentPost() {
        RentalsGamesItem rentalsGamesItem = new RentalsGamesItem();
        RentalsResponse rentalsResponse = new RentalsResponse();
        when(rentService.rentGames(any(RentalsGamesItem.class))).thenReturn(rentalsResponse);
        ResponseEntity<RentalsResponse> response = rentController.rentalsRentPost(rentalsGamesItem);
        verify(validations, times(1)).validateRentalsRequest(any(RentalsGamesItem.class));
        assertEquals(response.getBody(), rentalsResponse);
    }

    @Test
    @DisplayName("Test Rentals Return Post - status 200")
    void testRentalsReturnPost() {
        RentalReturnRequest rentalReturnRequest = new RentalReturnRequest();
        RentalReturnResponse rentalReturnResponse = new RentalReturnResponse();
        when(rentService.rentalsReturnPost(any(RentalReturnRequest.class))).thenReturn(ResponseEntity.ok(rentalReturnResponse));
        ResponseEntity<RentalReturnResponse> response = rentController.rentalsReturnPost(rentalReturnRequest);
        verify(validations, times(1)).validateRentalReturnRequest(any(RentalReturnRequest.class));
        assertEquals(response.getBody(), rentalReturnResponse);
    }
}