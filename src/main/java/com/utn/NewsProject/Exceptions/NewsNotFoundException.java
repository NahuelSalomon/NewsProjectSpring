package com.utn.NewsProject.Exceptions;

public class NewsNotFoundException extends RuntimeException {

    public NewsNotFoundException(String message) {
        super(message);
    }
}
