package com.example.tzrstech.exceptions;

public class InvalidCategoryException extends RuntimeException{
    public InvalidCategoryException() {
        super("Invalid category id or name.");
    }
}
