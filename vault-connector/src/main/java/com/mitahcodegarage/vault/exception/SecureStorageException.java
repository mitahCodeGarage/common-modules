package com.mitahcodegarage.vault.exception;

public class SecureStorageException extends RuntimeException{
    public SecureStorageException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public SecureStorageException(String errorMessage) {
        super(errorMessage);
    }
}
