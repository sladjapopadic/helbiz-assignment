package com.helbiz.helbizassignment.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<String> handleValidationException(ValidationException validationException) {
        Throwable cause = validationException.getCause();
        System.err.println(validationException.getMessage());
        if (cause != null) {
            System.err.println(cause.getMessage());
        }
        return new ResponseEntity<>(validationException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FileException.class)
    public ResponseEntity<String> handleFileException(FileException fileException) {
        System.err.println(fileException.getMessage() + " Error type: " + fileException.getCause().getMessage());
        return new ResponseEntity<>(fileException.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
