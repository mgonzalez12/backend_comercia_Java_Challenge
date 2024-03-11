package com.tech.apicomerciatech.application.services.utlis;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.openapitools.model.RentalsResponse;

import java.math.BigDecimal;

public class BuildRentalsResponses {
        public RentalsResponse buildRentalsResponse(Rent rent) {
            RentalsResponse rentResponse = new RentalsResponse();
            rentResponse.setId(rent.getId());  // Assuming Rent entity has an ID
            rentResponse.setIdCliente(rent.getCliente().getId());
            rentResponse.setIdJuego(rent.getJuego().getId());
            rentResponse.setDiasAlquilado(rent.getDiasAlquiladosSolicitados());
            rentResponse.setFechaInicio(rent.getFechaInicio());
            rentResponse.setPrecioTotal(BigDecimal.valueOf(rent.getPrecioTotal()));
            rentResponse.setRecargoRetraso(BigDecimal.valueOf(rent.getRecargoRetraso()));
            rentResponse.setPriceTotalRecargos(BigDecimal.valueOf(rent.getRecargoRetraso()).add(BigDecimal.valueOf(rent.getPrecioTotal())));
            return rentResponse;
        }
}
