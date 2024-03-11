package com.tech.apicomerciatech.infrastruture.rest.controller;

import com.tech.apicomerciatech.application.usecases.GameService;
import org.openapitools.api.GamesApi;
import org.openapitools.model.Game;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class GameController  implements GamesApi {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @Override
    public ResponseEntity<List<Game>> gamesGet() {
        List<Game> games = (List<Game>) gameService.findAll();
        return ResponseEntity.ok(games);
    }
    @Override
    public ResponseEntity<Game> gamesIdGet(Long id) {
        Optional<Game> game = Optional.ofNullable(gameService.findById(id));
        return game.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
