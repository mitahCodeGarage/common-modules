package com.mitahcodegarage.models.exceptions;

public class DownstreamServiceException extends RuntimeException{
    public DownstreamServiceException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public DownstreamServiceException(String errorMessage) {
        super(errorMessage);
    }
}
