package com.example.tzrstech.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException(Integer id) {
        super("Entity is not found, id = " + id);
    }

    public EntityNotFoundException(String entityName) {
        super("Entity with name: " + entityName + " not found");
    }
}
