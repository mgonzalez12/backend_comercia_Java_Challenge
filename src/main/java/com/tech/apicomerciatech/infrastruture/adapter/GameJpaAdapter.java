package com.tech.apicomerciatech.infrastruture.adapter;

import com.tech.apicomerciatech.domain.port.GamePersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.repository.GameRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GameJpaAdapter implements GamePersistencePort {

    public final GameRepository gameRepository;

    public GameJpaAdapter(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public List<Games> findAll() {
        return (List<Games>) gameRepository.findAll();
    }

    @Override
    public Games findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Game not found"));
    }
}
