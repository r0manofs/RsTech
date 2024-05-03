package com.example.tzrstech.exceptions;

public class EmptyCategoryException extends RuntimeException{
    public EmptyCategoryException() {
        super("Can't create product with empty category.");
    }
}
