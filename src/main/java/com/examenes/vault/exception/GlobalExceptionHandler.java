package com.examenes.vault.exception;

import com.examenes.vault.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // Todas las excepciones que surjan en la aplicacion, entran aca
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<ApiError> handleException(RequestException ex, WebRequest request) {
        ApiError apiError = new ApiError(ex.getCode(), ex.getMessage());
        return new ResponseEntity(apiError, HttpStatus.valueOf(ex.getStatus()));
    }
}
