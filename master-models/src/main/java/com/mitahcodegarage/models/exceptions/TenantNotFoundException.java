package com.mitahcodegarage.models.exceptions;

public class TenantNotFoundException extends RuntimeException{
    public TenantNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public TenantNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
