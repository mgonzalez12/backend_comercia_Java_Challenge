package com.tech.apicomerciatech.application.usecases;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalReturnResponse;
import org.openapitools.model.RentalsGamesItem;
import org.openapitools.model.RentalsResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RentService {

     RentalsResponse rentGames(RentalsGamesItem rentalsGamesItem);
     ResponseEntity<RentalReturnResponse> rentalsReturnPost(RentalReturnRequest rentalReturnRequest);

     List<Rent> findByClientId(Long clientId);

}
