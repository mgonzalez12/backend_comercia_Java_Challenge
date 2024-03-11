package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Rent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.RentalsGamesItem;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentDboMapperTest {
    @Mock
    private RentDboMapper rentDboMapper;

    @Test
    void testRentDboMapper() {
        Rent entity = new Rent();
        entity.setId(1L);
        RentalsGamesItem dbo = new RentalsGamesItem();
        dbo.setIdCliente(1L);

        when(rentDboMapper.toDbo(entity)).thenReturn(dbo);
        when(rentDboMapper.toEntity(dbo)).thenReturn(entity);
        assertAll(
                () -> assertEquals(dbo, rentDboMapper.toDbo(entity)),
                ()-> assertEquals(entity, rentDboMapper.toEntity(dbo))
        );
    }
}