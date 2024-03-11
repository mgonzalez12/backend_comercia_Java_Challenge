package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.RentalsListResponse;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalsListResponseMapperTest {
    @Mock
    private RentalsListResponseMapper rentalsListResponseMapper;

    @Test
    void testToDto() {
        Rent entity = new Rent();
        entity.setId(1L);
        entity.setDiasAlquiladosSolicitados(5);
        entity.setFechaInicio(LocalDate.now());
        entity.setFechaFin(LocalDate.now().plusDays(5));
        entity.setPrecioTotal(100.0);
        entity.setRecargoRetraso(10.0);

        Games juego = new Games();
        juego.setId(1L);
        entity.setJuego(juego);

        RentalsListResponse dto = new RentalsListResponse();
        dto.setIdJuego(juego.getId());
        dto.setDiasAlquilado(entity.getDiasAlquiladosSolicitados());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());
        dto.setPrecioTotalSinRecargo(BigDecimal.valueOf(entity.getPrecioTotal()));
        dto.setRecargoRetraso(BigDecimal.valueOf(entity.getRecargoRetraso()));

        when(rentalsListResponseMapper.toDto(entity)).thenReturn(dto);
        RentalsListResponse result = rentalsListResponseMapper.toDto(entity);
        assertEquals(dto, result);
    }
}