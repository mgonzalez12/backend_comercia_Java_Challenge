package com.tech.apicomerciatech.infrastruture.adapter.enums;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TipoJuegoTest {

    @Test
    void testTipoJuego() {
        Games juego = new Games();

        juego.setType(TipoJuego.NEW_RELEASE);
        assertEquals(TipoJuego.NEW_RELEASE, juego.getType());

        juego.setType(TipoJuego.STANDARD_GAME);
        assertEquals(TipoJuego.STANDARD_GAME, juego.getType());

        juego.setType(TipoJuego.CLASSIC_GAME);
        assertEquals(TipoJuego.CLASSIC_GAME, juego.getType());
    }

}