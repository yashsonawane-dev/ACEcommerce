package com.example.AlgoCampEcom.exception;

public class ProductNotFoundException extends RuntimeException {

    private String name;

    public ProductNotFoundException(String message) {
        super(message);
    }
}
