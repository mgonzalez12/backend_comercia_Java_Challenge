package com.tech.apicomerciatech.infrastruture.adapter.entity;

import static org.junit.jupiter.api.Assertions.*;
import com.tech.apicomerciatech.infrastruture.adapter.enums.TipoJuego;
import org.junit.jupiter.api.Test;


class GamesTest {

    @Test
    void testGames() {
        Games game = new Games();
        game.setId(1L);
        game.setTitle("Game 1");
        game.setType(TipoJuego.NEW_RELEASE);
        game.setPremiumPrice(20.0);
        game.setBasicPrice(10.0);
        assertAll(
                () -> assertEquals(1L, game.getId()),
                () -> assertEquals("Game 1", game.getTitle()),
                () -> assertEquals(TipoJuego.NEW_RELEASE, game.getType()),
                () -> assertEquals(20.0, game.getPremiumPrice()),
                () -> assertEquals(10.0, game.getBasicPrice())
        );
    }

}