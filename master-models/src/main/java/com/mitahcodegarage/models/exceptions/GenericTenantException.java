package com.mitahcodegarage.models.exceptions;

public class GenericTenantException extends RuntimeException{
    public GenericTenantException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public GenericTenantException(String errorMessage) {
        super(errorMessage);
    }
}
