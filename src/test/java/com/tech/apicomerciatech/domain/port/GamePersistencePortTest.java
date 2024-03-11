package com.tech.apicomerciatech.domain.port;

import com.tech.apicomerciatech.infrastruture.adapter.GameJpaAdapter;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.repository.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GamePersistencePortTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameJpaAdapter gameJpaAdapter;

    @Test
    void testFindAllGames() {
        Games game = new Games();
        game.setId(1L);
        when(gameRepository.findAll()).thenReturn(Arrays.asList(game));
        List<Games> result = gameJpaAdapter.findAll();
        assertEquals(Arrays.asList(game), result);
    }

    @Test
    void testFindGameById() {
        Games game = new Games();
        game.setId(1L);
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));
        Games result = gameJpaAdapter.findById(1L);
        assertEquals(game, result);
    }

}