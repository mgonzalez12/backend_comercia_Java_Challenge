package com.tech.apicomerciatech.application.usecases;

import org.openapitools.model.Game;

import java.util.List;

public interface GameService {
    List<Game> findAll();
    Game findById(Long id);
}
