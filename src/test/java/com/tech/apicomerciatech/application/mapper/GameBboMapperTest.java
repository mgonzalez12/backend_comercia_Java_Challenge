package com.tech.apicomerciatech.application.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.Game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameBboMapperTest {

    @Mock
    private GameBboMapper gameBboMapper;

    @Test
    void testGameBboMapper() {
        Games entity = new Games();
        entity.setId(1L);
        Game dbo = new Game();
        dbo.setId(1L);

        when(gameBboMapper.toDbo(entity)).thenReturn(dbo);
        when(gameBboMapper.toEntity(dbo)).thenReturn(entity);
        assertAll(
                () -> assertEquals(dbo, gameBboMapper.toDbo(entity)),
                ()-> assertEquals(entity, gameBboMapper.toEntity(dbo))
        );
    }


}