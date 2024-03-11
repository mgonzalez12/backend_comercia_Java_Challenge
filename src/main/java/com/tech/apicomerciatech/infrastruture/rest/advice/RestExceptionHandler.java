package com.tech.apicomerciatech.infrastruture.rest.advice;

import com.tech.apicomerciatech.infrastruture.adapter.exception.ClientNotFoundException;
import com.tech.apicomerciatech.infrastruture.adapter.exception.ErrorMessage;
import com.tech.apicomerciatech.infrastruture.adapter.exception.GameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.util.HashMap;
import java.util.Map;

import static com.tech.apicomerciatech.domain.constant.MessageContant.*;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?> handleClientNotFound(ClientNotFoundException e) {
        Map<String, String> error = new HashMap<>();
        error.put(TEXT_ERROR, SEARCH_ID_ERROR);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(GameNotFoundException.class)
    public ResponseEntity<?> handleGameNotFound(GameNotFoundException e) {
        Map<String, String> error = new HashMap<>();
        error.put(TEXT_ERROR, SEARCH_ID_ERROR);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<?> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, String> error = new HashMap<>();
        String paramName = ex.getName();
        Class<?> paramType = ex.getRequiredType();
        String errorMessage = TEXT_PARAMETRO  + paramName + TEXT_DEBE_SER_DE_TIPO
                + (paramType != null ? paramType.getSimpleName() : TEXT_DESCONOCIDO) + "'.";
        error.put(TEXT_ERROR, errorMessage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        Map<String, String> error = new HashMap<>();
        error.put(TEXT_ERROR, STATUS_500_ERROR_SERVER);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(IllegalArgumentException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
    }


}
