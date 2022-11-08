package com.mitahcodegarage.kafkapublish.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mitahcodegarage.models.BatchStatusRecord;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Serializer;
import org.springframework.util.SerializationUtils;

import java.util.Map;

public class BatchStatusRecordSerializer implements Serializer<BatchStatusRecord> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, BatchStatusRecord batchStatusRecord) {
            if(null == batchStatusRecord) {
                return null;
            }
            return SerializationUtils.serialize(batchStatusRecord);
    }

    @Override
    public byte[] serialize(String topic, Headers headers, BatchStatusRecord data) {
        return Serializer.super.serialize(topic, headers, data);
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
