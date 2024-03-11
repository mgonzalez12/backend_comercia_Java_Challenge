package com.tech.apicomerciatech.infrastruture.adapter.repository;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class GameRepositoryTest {

    @Mock
    private GameRepository gameRepository;

    @Test
    void testFindAllGames() {
        Games game = new Games();
        game.setId(1L);
        when(gameRepository.findAll()).thenReturn(Arrays.asList(game));
        List<Games> result = gameRepository.findAll();
        assertEquals(Arrays.asList(game), result);
    }

    @Test
    void testFindGameById() {
        Games game = new Games();
        game.setId(1L);
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));
        Games result = gameRepository.findById(1L).orElse(null);
        assertEquals(game, result);
    }

}