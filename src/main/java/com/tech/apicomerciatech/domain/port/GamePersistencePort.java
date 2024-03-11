package com.tech.apicomerciatech.domain.port;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;

import java.util.List;

public interface GamePersistencePort {
    List<Games> findAll();
    Games findById(Long id);
}
