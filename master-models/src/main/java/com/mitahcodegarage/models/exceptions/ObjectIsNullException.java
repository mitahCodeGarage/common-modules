package com.mitahcodegarage.models.exceptions;

public class ObjectIsNullException extends RuntimeException{
    public ObjectIsNullException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ObjectIsNullException(String errorMessage) {
        super(errorMessage);
    }
    public ObjectIsNullException() {
        super();
    }
}
