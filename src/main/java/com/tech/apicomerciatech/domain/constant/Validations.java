package com.tech.apicomerciatech.domain.constant;

import org.openapitools.model.ClientCreate;
import org.openapitools.model.RentalReturnRequest;
import org.openapitools.model.RentalsGamesItem;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.tech.apicomerciatech.domain.constant.MessageContant.*;

@Component
public class Validations {
    public void validateRentalsRequest(RentalsGamesItem rentalsGamesItem) {
        Optional.ofNullable(rentalsGamesItem)
                .filter(item -> item.getIdCliente() != null && item.getIdCliente() > 0)
                .filter(item -> item.getIdJuego() != null && item.getIdJuego() > 0)
                .filter(item -> item.getDiasAlquilado() != null && item.getDiasAlquilado() > 0)
                .filter(item -> item.getFechaInicio() != null)
                .orElseThrow(() -> new IllegalArgumentException(FALTAN_CAMPOS_OBLIGATORIOS));
    }
    public void validateRentalReturnRequest(RentalReturnRequest rentalReturnRequest){
        Optional.ofNullable(rentalReturnRequest)
                .filter(request -> request.getIdAlquiler() != null && request.getIdAlquiler() > 0)
                .orElseThrow(() -> new IllegalArgumentException(FALTAN_CAMPOS_OBLIGATORIOS));
    }

    public void validateClientRequest(ClientCreate clientCreate) {
        Optional.ofNullable(clientCreate)
                .filter(client -> client.getName() != null && !client.getName().trim().isEmpty())
                .orElseThrow(() -> new IllegalArgumentException(FALTAN_CAMPOS_OBLIGATORIOS));
    }
}
