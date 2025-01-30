package com.School_management.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(final String message) {
        super(message);
    }
}
