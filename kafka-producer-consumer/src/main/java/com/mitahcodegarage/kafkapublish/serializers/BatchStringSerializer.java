package com.mitahcodegarage.kafkapublish.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitahcodegarage.models.Batch;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.util.SerializationUtils;

import java.util.Map;

public class BatchStringSerializer implements Serializer<Batch<String>> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, Batch<String> batch) {
            if(null == batch) {
                return null;
            }
            return SerializationUtils.serialize(batch);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, Batch<String> batch) {
        return Serializer.super.serialize(topic, headers, batch);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
