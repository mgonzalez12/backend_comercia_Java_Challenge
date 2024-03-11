package com.tech.apicomerciatech.application.services;

import com.tech.apicomerciatech.application.mapper.GameBboMapper;
import com.tech.apicomerciatech.domain.port.GamePersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.exception.GameNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.openapitools.model.Game;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceImplTest {

    @Mock
    private GamePersistencePort gamePersistencePort;

    @Mock
    private GameBboMapper gameBboMapper;

    @InjectMocks
    private GameServiceImpl gameService;

    @Test
    @DisplayName("Test Game find All - status 200")
    void testFindAll() {
        Games gameEntity = new Games();
        Game gameDto = new Game();
        when(gamePersistencePort.findAll()).thenReturn(Arrays.asList(gameEntity));
        when(gameBboMapper.toDbo(gameEntity)).thenReturn(gameDto);
        List<Game> result = gameService.findAll();
        assertAll(
                () -> assertEquals(1, result.size()),
                () -> assertEquals(gameDto, result.get(0))
        );
    }

    @Test
    @DisplayName("Test Game Find By Id - status 200")
    void testFindById() {
        Games gameEntity = new Games();
        Game gameDto = new Game();
        when(gamePersistencePort.findById(1L)).thenReturn(gameEntity);
        when(gameBboMapper.toDbo(gameEntity)).thenReturn(gameDto);
        Game result = gameService.findById(1L);
        assertEquals(gameDto, result);
    }

    @Test
    @DisplayName("Test Game Find By Id Not Found")
    void testFindByIdNotFound() {
        when(gamePersistencePort.findById(1L)).thenThrow(new EntityNotFoundException());
        assertThrows(GameNotFoundException.class, () -> gameService.findById(1L));
    }

}