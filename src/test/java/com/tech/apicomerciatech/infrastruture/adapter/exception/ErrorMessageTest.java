package com.tech.apicomerciatech.infrastruture.adapter.exception;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ErrorMessageTest {

    @Test
    void testErrorMessage() {
        String testMessage = "Test message";
        ErrorMessage errorMessage = new ErrorMessage(testMessage);
        assertEquals(testMessage, errorMessage.getMessage());
    }

}