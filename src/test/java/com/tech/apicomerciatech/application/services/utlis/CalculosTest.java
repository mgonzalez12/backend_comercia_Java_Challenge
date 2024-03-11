package com.tech.apicomerciatech.application.services.utlis;

import com.tech.apicomerciatech.infrastruture.adapter.entity.Games;
import com.tech.apicomerciatech.infrastruture.adapter.enums.TipoJuego;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculosTest {

    @Test
    @DisplayName("Test Calculate Base Price")
    void testCalculateBasePrice() {
        Games game = new Games();
        game.setPremiumPrice(20.0);
        game.setBasicPrice(10.0);
        game.setType(TipoJuego.NEW_RELEASE);
        assertEquals(20.0, Calculos.calculateBasePrice(game));
        game.setType(TipoJuego.STANDARD_GAME);
        assertEquals(10.0, Calculos.calculateBasePrice(game));
        game.setType(TipoJuego.CLASSIC_GAME);
        assertEquals(10.0, Calculos.calculateBasePrice(game));
        game.setType(null);
        assertThrows(RuntimeException.class, () -> Calculos.calculateBasePrice(game));
    }

    @Test
    @DisplayName("Test Calculate Total Price")
    void testCalculateTotalPrice() {
        Games game = new Games();
        game.setPremiumPrice(20.0);
        game.setBasicPrice(10.0);
        BigDecimal basePrice = BigDecimal.valueOf(10.0);
        game.setType(TipoJuego.NEW_RELEASE);
        assertEquals(100.0, Calculos.calculateTotalPrice(10, basePrice, game));
        game.setType(TipoJuego.STANDARD_GAME);
        assertEquals(100.0, Calculos.calculateTotalPrice(10, basePrice, game));
        game.setType(TipoJuego.CLASSIC_GAME);
        assertEquals(100.0, Calculos.calculateTotalPrice(10, basePrice, game));
        game.setType(null);
        assertThrows(RuntimeException.class, () -> Calculos.calculateTotalPrice(10, basePrice, game));
        assertThrows(IllegalArgumentException.class, () -> Calculos.calculateTotalPrice(0, basePrice, game));
    }
}
