package com.examenes.vault.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // Agrega getter, setter, y otros metodos mas tipo hashCode, equals, y no args constructor
@AllArgsConstructor
public class RequestException extends RuntimeException {
    private String message;
    private String code;
    private int status;
}
