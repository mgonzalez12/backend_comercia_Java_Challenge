package com.tech.apicomerciatech.application.services;

import com.tech.apicomerciatech.application.mapper.GameBboMapper;
import com.tech.apicomerciatech.application.usecases.GameService;
import com.tech.apicomerciatech.domain.port.GamePersistencePort;
import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.exception.GameNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.openapitools.model.Game;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {

    private final GamePersistencePort gamePersistencePort;
    private final GameBboMapper gameBboMapper;

    public GameServiceImpl(GamePersistencePort gamePersistencePort, GameBboMapper gameBboMapper) {
        this.gamePersistencePort = gamePersistencePort;
        this.gameBboMapper = gameBboMapper;
    }

    @Override
    public List<Game> findAll() {
        List<Games> allGamesEntities = gamePersistencePort.findAll();
        List<Game> allGamesDtos = new ArrayList<>();
        for (Games gameEntity : allGamesEntities) {
            allGamesDtos.add(gameBboMapper.toDbo(gameEntity));
        }
        return allGamesDtos;

    }

    @Override
    public Game findById(Long id) {
        try {
        Games gameEntity = gamePersistencePort.findById(id);
        Game gameDto = gameBboMapper.toDbo(gameEntity);
        return gameDto;
        } catch (EntityNotFoundException e) {
            throw new GameNotFoundException();
        }
    }
}
