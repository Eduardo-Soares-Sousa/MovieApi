package com.eduardo.movieApi.business.exceptions;

public class MovieNotFoundException extends RuntimeException {
    public MovieNotFoundException(String message) {
        super(message);
    }

    public MovieNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
