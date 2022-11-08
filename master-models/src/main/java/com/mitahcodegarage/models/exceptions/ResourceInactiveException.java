package com.mitahcodegarage.models.exceptions;

public class ResourceInactiveException extends RuntimeException{
    public ResourceInactiveException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public ResourceInactiveException(String errorMessage) {
        super(errorMessage);
    }
}
