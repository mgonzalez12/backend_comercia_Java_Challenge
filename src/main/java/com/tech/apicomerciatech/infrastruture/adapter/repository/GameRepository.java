package com.tech.apicomerciatech.infrastruture.adapter.repository;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Games,Long> {
}
