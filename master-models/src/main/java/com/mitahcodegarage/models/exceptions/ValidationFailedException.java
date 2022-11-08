package com.mitahcodegarage.models.exceptions;

public class ValidationFailedException extends RuntimeException{
    public ValidationFailedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ValidationFailedException(String errorMessage) {
        super(errorMessage);
    }
}
