package com.tech.apicomerciatech.infrastruture.rest.advice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.tech.apicomerciatech.infrastruture.adapter.exception.ClientNotFoundException;
import com.tech.apicomerciatech.infrastruture.adapter.exception.ErrorMessage;
import com.tech.apicomerciatech.infrastruture.adapter.exception.GameNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

class RestExceptionHandlerTest {

    private RestExceptionHandler handler = new RestExceptionHandler();

    @Test
    void testHandleClientNotFound() {
        ClientNotFoundException exception = new ClientNotFoundException();
        ResponseEntity<?> response = handler.handleClientNotFound(exception);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testHandleGameNotFound() {
        GameNotFoundException exception = new GameNotFoundException();
        ResponseEntity<?> response = handler.handleGameNotFound(exception);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testHandleMethodArgumentTypeMismatch() {
        MethodArgumentTypeMismatchException exception = new MethodArgumentTypeMismatchException("value", String.class, "name", null, null);
        ResponseEntity<?> response = handler.handleMethodArgumentTypeMismatch(exception);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void testHandleGenericException() {
        Exception exception = new Exception();
        ResponseEntity<?> response = handler.handleGenericException(exception);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void testHandleValidationException() {
        IllegalArgumentException exception = new IllegalArgumentException("error message");
        ResponseEntity<ErrorMessage> response = handler.handleValidationException(exception);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals("error message", response.getBody().getMessage());
    }
}
