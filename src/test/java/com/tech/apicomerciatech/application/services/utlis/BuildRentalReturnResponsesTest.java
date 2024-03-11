package com.tech.apicomerciatech.application.services.utlis;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openapitools.model.ClientSearch;
import org.openapitools.model.RentalReturnResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildRentalReturnResponsesTest {

    @Test
    @DisplayName("Test Build Rental Return Response")
    void testBuildRentalReturnResponse() {
        BuildRentalReturnResponses buildRentalReturnResponses = new BuildRentalReturnResponses();
        Rent rent = new Rent();
        rent.setDiasAlquiladosSolicitados(5);
        rent.setFechaInicio(LocalDate.now());
        rent.setFechaFin(LocalDate.now().plusDays(5));
        rent.setDiasAlquiladosReales(5);
        rent.setPrecioTotal(100.0);
        ClientSearch client = new ClientSearch();
        client.setId(1L);
        double recargo = 10.0;
        double preciosRecargoTotal = 110.0;
        RentalReturnResponse result = buildRentalReturnResponses.buildRentalReturnResponse(rent, client, recargo, preciosRecargoTotal);
        assertAll(
                () -> assertEquals(client.getId(), result.getIdCliente()),
                ()->  assertEquals(BigDecimal.valueOf(recargo), result.getRecargos()),
                ()-> assertEquals(rent.getDiasAlquiladosSolicitados(), result.getDiasAlquilado()),
                ()-> assertEquals(rent.getFechaInicio(), result.getFechaInicio()),
                ()-> assertEquals(rent.getFechaFin(), result.getFechaFin()),
                ()-> assertEquals(rent.getDiasAlquiladosReales(), result.getDiasAlquiladosReales()),
                ()-> assertEquals(BigDecimal.valueOf(rent.getPrecioTotal()), result.getPrecioTotal()),
                ()-> assertEquals(BigDecimal.valueOf(preciosRecargoTotal), result.getPriceTotalRecargos())
        );
    }
}
