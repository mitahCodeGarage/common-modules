package com.mitahcodegarage.models.exceptions;

public class GenericProcessingException extends RuntimeException{
    private String requestId;
    public GenericProcessingException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public GenericProcessingException(String errorMessage, String requestId, Throwable err) {
        super(errorMessage, err);
        this.requestId = requestId;
    }

    public GenericProcessingException(String errorMessage) {
        super(errorMessage);
    }

    public GenericProcessingException(String errorMessage, String requestId) {
        super(errorMessage);
    }

    public String getRequestId() {
        return requestId;
    }
}
