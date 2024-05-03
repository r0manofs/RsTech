package com.example.tzrstech.controllerAdvices;

import com.example.tzrstech.exceptions.EmptyCategoryException;
import com.example.tzrstech.exceptions.EntityNotFoundException;
import com.example.tzrstech.exceptions.InvalidCategoryException;
import com.example.tzrstech.wrappers.ExceptionWrapper;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class controllerAdvice {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionWrapper> handleEntityNotFoundException(EntityNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionWrapper(exception.getMessage()));
    }

    @ExceptionHandler(EmptyCategoryException.class)
    public ResponseEntity<ExceptionWrapper> handleEmptyCategoryException(EmptyCategoryException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ExceptionWrapper(exception.getMessage()));
    }

    @ExceptionHandler(InvalidCategoryException.class)
    public ResponseEntity<ExceptionWrapper> handleInvalidCategoryException(InvalidCategoryException exception) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionWrapper(exception.getMessage()));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ExceptionWrapper> validationException(ConstraintViolationException exception) {
        String exceptionMessage = exception.getConstraintViolations().stream().toList().get(0).getMessage();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ExceptionWrapper(exceptionMessage));
    }
}
