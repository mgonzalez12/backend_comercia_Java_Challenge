package com.tech.apicomerciatech.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalReturnResponse;
import org.openapitools.model.RentalsGamesItem;
import org.openapitools.model.RentalsResponse;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
class RentServiceTest {

    @Mock
    private RentService rentService;

    @Test
    @DisplayName("Test Rentals Return Post ")
    void testRentGames() {
        RentalsGamesItem rentalsGamesItem = new RentalsGamesItem();
        rentalsGamesItem.setIdCliente(1L);
        rentalsGamesItem.setIdJuego(1L);
        RentalsResponse rentalsResponse = new RentalsResponse();
        rentalsResponse.setId(1L);

        when(rentService.rentGames(rentalsGamesItem)).thenReturn(rentalsResponse);
        RentalsResponse result = rentService.rentGames(rentalsGamesItem);
        assertEquals(rentalsResponse, result);
    }

    @Test
    @DisplayName("Test Rentals Return Post ")
    void testRentalsReturnPost() {
        RentalReturnRequest rentalReturnRequest = new RentalReturnRequest();
        rentalReturnRequest.setIdAlquiler(1L);
        RentalReturnResponse rentalReturnResponse = new RentalReturnResponse();
        rentalReturnResponse.setIdCliente(1L);

        when(rentService.rentalsReturnPost(rentalReturnRequest)).thenReturn(ResponseEntity.ok(rentalReturnResponse));
        ResponseEntity<RentalReturnResponse> result = rentService.rentalsReturnPost(rentalReturnRequest);
        assertEquals(ResponseEntity.ok(rentalReturnResponse), result);
    }

    @Test
    @DisplayName("Test Find By Client Id ")
    void testFindByClientId() {
        Rent rent = new Rent();
        rent.setId(1L);

        when(rentService.findByClientId(1L)).thenReturn(Arrays.asList(rent));
        List<Rent> result = rentService.findByClientId(1L);
        assertEquals(Arrays.asList(rent), result);
    }
}
