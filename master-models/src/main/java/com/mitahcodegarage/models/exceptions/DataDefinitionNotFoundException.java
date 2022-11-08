package com.mitahcodegarage.models.exceptions;

public class DataDefinitionNotFoundException extends RuntimeException{
    public DataDefinitionNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public DataDefinitionNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
