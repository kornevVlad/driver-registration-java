package com.example.driversregistrationjava.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResponse {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationBadRequest.class)
    public ErrorResponse errorValidationBadRequest(final ValidationBadRequest e) {
        return new ErrorResponse(e.getMessage());
    }
}
