package com.tech.apicomerciatech.infrastruture.adapter.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameNotFoundExceptionTest {

    @Test
    void testGameNotFoundException() {
        Exception exception = assertThrows(GameNotFoundException.class, () -> {
            throw new GameNotFoundException();
        });
        assertEquals(GameNotFoundException.class, exception.getClass());
    }

}