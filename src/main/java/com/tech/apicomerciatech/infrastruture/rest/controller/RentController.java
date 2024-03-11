package com.tech.apicomerciatech.infrastruture.rest.controller;

import com.tech.apicomerciatech.application.usecases.RentService;
import com.tech.apicomerciatech.domain.constant.Validations;
import org.openapitools.api.RentalsApi;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalReturnResponse;
import org.openapitools.model.RentalsGamesItem;
import org.openapitools.model.RentalsResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RentController implements RentalsApi {

    private final RentService rentService;
    private final Validations validations;

    public RentController(RentService rentService, Validations validations) {
        this.rentService = rentService;
        this.validations = validations;
    }

    @Override
    public ResponseEntity<RentalsResponse> rentalsRentPost(RentalsGamesItem rentalsGamesItem) {
        validations.validateRentalsRequest(rentalsGamesItem);
        RentalsResponse rentResponse = rentService.rentGames(rentalsGamesItem);
        return ResponseEntity.ok(rentResponse);

    }

    @Override
    public ResponseEntity<RentalReturnResponse> rentalsReturnPost(RentalReturnRequest rentalReturnRequest) {
        validations.validateRentalReturnRequest(rentalReturnRequest);
        RentalReturnResponse rentalReturnResponse = rentService.rentalsReturnPost(rentalReturnRequest).getBody();
        return ResponseEntity.ok(rentalReturnResponse);

    }
}
