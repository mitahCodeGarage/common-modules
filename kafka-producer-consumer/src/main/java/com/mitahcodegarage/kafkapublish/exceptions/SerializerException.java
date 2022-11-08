package com.mitahcodegarage.kafkapublish.exceptions;

public class SerializerException extends RuntimeException{
    public SerializerException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public SerializerException(String errorMessage) {
        super(errorMessage);
    }
}
