package com.tech.apicomerciatech.infrastruture.adapter.mapper;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.Game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameMapperTest {
    @Mock
    private GameMapper gameMapper;

    @Test
    void testGameMapper() {
        Games entity = new Games();
        entity.setTitle("Game 1");
        Game dbo = new Game();
        dbo.setTitle("Game 1");

        when(gameMapper.toDbo(entity)).thenReturn(dbo);
        when(gameMapper.toEntity(dbo)).thenReturn(entity);

        assertEquals(dbo, gameMapper.toDbo(entity));
        assertEquals(entity, gameMapper.toEntity(dbo));
    }

}