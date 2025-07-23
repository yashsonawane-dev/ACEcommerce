package com.example.AlgoCampEcom.exception;

public class CategoryNotFoundException extends RuntimeException {

    private String name;

    public CategoryNotFoundException(String message) {
        super(message);
    }
}
