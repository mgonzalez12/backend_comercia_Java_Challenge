package com.tech.apicomerciatech.application.usecases;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.openapitools.model.Game;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private GameService gameService;

    @Test
    @DisplayName("Test Find All ")
     void testFindAll() {
        Game game = new Game();
        game.setId(1L);
        when(gameService.findAll()).thenReturn(Arrays.asList(game));
        List<Game> result = gameService.findAll();
        assertEquals(Arrays.asList(game), result);
    }

    @Test
    @DisplayName("Test Find By Id ")
    void testFindById() {
        Game game = new Game();
        game.setId(1L);
        when(gameService.findById(1L)).thenReturn(game);
        Game result = gameService.findById(1L);
        assertEquals(game, result);
    }
}
