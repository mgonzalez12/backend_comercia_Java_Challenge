package com.tech.apicomerciatech.application.services.utlis;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.openapitools.model.ClientSearch;
import org.openapitools.model.RentalReturnResponse;

import java.math.BigDecimal;

public class BuildRentalReturnResponses {
    public RentalReturnResponse buildRentalReturnResponse(Rent rent, ClientSearch client, double recargo, double preciosRecargoTotal) {
        RentalReturnResponse rentalReturnResponse = new RentalReturnResponse();
        rentalReturnResponse.setIdCliente(client.getId());
        rentalReturnResponse.setRecargos(BigDecimal.valueOf(recargo));
        rentalReturnResponse.setDiasAlquilado(rent.getDiasAlquiladosSolicitados());
        rentalReturnResponse.setFechaInicio(rent.getFechaInicio());
        rentalReturnResponse.setFechaFin(rent.getFechaFin());
        rentalReturnResponse.setDiasAlquiladosReales(rent.getDiasAlquiladosReales());
        rentalReturnResponse.setPrecioTotal(BigDecimal.valueOf(rent.getPrecioTotal()));
        rentalReturnResponse.setPriceTotalRecargos(BigDecimal.valueOf(preciosRecargoTotal));
        return rentalReturnResponse;
    }

}
