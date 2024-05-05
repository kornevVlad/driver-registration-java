package com.example.driversregistrationjava.validation;

public class ValidationBadRequest extends RuntimeException {

    public ValidationBadRequest(String message) {
        super(message);
    }
}
