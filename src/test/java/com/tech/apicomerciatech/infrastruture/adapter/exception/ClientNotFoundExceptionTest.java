package com.tech.apicomerciatech.infrastruture.adapter.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ClientNotFoundExceptionTest {

    @Test
    void testClientNotFoundException() {
        Exception exception = assertThrows(ClientNotFoundException.class, () -> {
            throw new ClientNotFoundException();
        });

        assertEquals(ClientNotFoundException.class, exception.getClass());
    }
}