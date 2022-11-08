package com.mitahcodegarage.models.exceptions;

public class InvalidRequestException extends RuntimeException{
    public InvalidRequestException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InvalidRequestException(String errorMessage) {
        super(errorMessage);
    }
}
