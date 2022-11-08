package com.mitahcodegarage.vault.exception;

public class VaultConnectionNotFoundException extends RuntimeException{
    public VaultConnectionNotFoundException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public VaultConnectionNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
