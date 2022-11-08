package com.mitahcodegarage.kafkapublish.deserializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitahcodegarage.models.Batch;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.util.SerializationUtils;

import java.util.Map;

public class BatchStringDeserializer implements Deserializer<Batch<String>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        Deserializer.super.configure(configs, isKey);
    }

    @Override
    public Batch<String> deserialize(String topic, byte[] bytes) {
        if (bytes == null){
            return null;
        }
        return (Batch) SerializationUtils.deserialize(bytes);
    }

    @Override
    public Batch<String> deserialize(String topic, Headers headers, byte[] data) {
        return Deserializer.super.deserialize(topic, headers, data);
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
