package com.tech.apicomerciatech.infrastruture.rest.controller;

import com.tech.apicomerciatech.application.usecases.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.openapitools.model.Game;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GameControllerTest {
    @InjectMocks
    GameController gameController;

    @Mock
    GameService gameService;

    @BeforeEach
    void setUp() {  MockitoAnnotations.openMocks(this); }

    @Test
    @DisplayName("Test Game find All - status 200")
    void testGamesGet() {
        Game game1 = new Game();
        Game game2 = new Game();
        List<Game> games = Arrays.asList(game1, game2);
        when(gameService.findAll()).thenReturn(games);
        ResponseEntity<List<Game>> response = gameController.gamesGet();
        assertEquals(response.getBody(), games);
    }

    @Test
    @DisplayName("Test Games find By Id - status 200")
    void testGamesIdGet() {
        Long id = 1L;
        Game game = new Game();
        when(gameService.findById(id)).thenReturn(game);
        ResponseEntity<Game> response = gameController.gamesIdGet(id);
        assertEquals(response.getBody(), game);
    }

}