package com.mitahcodegarage.kafkapublish.exceptions;

public class ConsumerNotFoundException extends RuntimeException{
    public ConsumerNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ConsumerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
