package com.tech.apicomerciatech.infrastruture.adapter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class GameJpaAdapterTest {

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameJpaAdapter gameJpaAdapter;

    @Test
    @DisplayName("Test Find All")
    void testFindAll() {
        Games game = new Games();
        game.setId(1L);
        when(gameRepository.findAll()).thenReturn(Arrays.asList(game));
        List<Games> result = gameJpaAdapter.findAll();
        assertEquals(Arrays.asList(game), result);
    }

    @Test
    @DisplayName("Test Find By Id")
    void testFindById() {
        Games game = new Games();
        game.setId(1L);
        when(gameRepository.findById(1L)).thenReturn(Optional.of(game));
        Games result = gameJpaAdapter.findById(1L);
        assertEquals(game, result);
    }

    @Test
    @DisplayName("Test Find By Id Not Found")
    void testFindByIdNotFound() {
        when(gameRepository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> gameJpaAdapter.findById(1L));
    }
}
