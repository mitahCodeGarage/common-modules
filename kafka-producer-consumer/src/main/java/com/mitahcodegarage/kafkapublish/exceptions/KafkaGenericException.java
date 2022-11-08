package com.mitahcodegarage.kafkapublish.exceptions;

public class KafkaGenericException extends RuntimeException{
    public KafkaGenericException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public KafkaGenericException(String errorMessage) {
        super(errorMessage);
    }
}

