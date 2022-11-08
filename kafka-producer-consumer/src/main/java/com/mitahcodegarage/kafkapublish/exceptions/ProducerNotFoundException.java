package com.mitahcodegarage.kafkapublish.exceptions;

public class ProducerNotFoundException extends RuntimeException{
    public ProducerNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ProducerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
