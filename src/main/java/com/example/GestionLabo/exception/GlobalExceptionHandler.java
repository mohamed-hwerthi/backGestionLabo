package com.example.GestionLabo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelUserNotFoundException(CustomNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(PasswordNotRelyException.class)
    public ResponseEntity<ErrorResponse> handelPasswordNotRelyException(PasswordNotRelyException ex) {
        ErrorResponse errorResponse = new ErrorResponse(401, ex.getMessage());
        return ResponseEntity.status(401).body(errorResponse);
    }

    @ExceptionHandler(UserWithEmailNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelUserWithEmailNotFoundException(UserWithEmailNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(401, ex.getMessage());
        return ResponseEntity.status(401).body(errorResponse);
    }
}
