package com.example.maratonchallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthNotValidException extends RuntimeException {
    public AuthNotValidException(String message) {
        super(message);
    }
}
