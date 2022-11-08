package com.mitahcodegarage.kafkapublish.service;

import io.confluent.kafka.streams.serdes.avro.GenericAvroSerde;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.common.serialization.Serde;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Map;

public class GenericSerdeService {
    private static final Logger logger = LogManager.getLogger();

    private String schemaRegistryUrl;

    public GenericSerdeService(String schemaRegistryUrl) {
        this.schemaRegistryUrl = schemaRegistryUrl;
    }

    public Serde<GenericRecord> createGenericSerdes(boolean isKey) {
        logger.debug("Creating a generic serde with schema registry url [{}]", schemaRegistryUrl);
        Map<String, String> serdeConfig = Collections.singletonMap("schema.registry.url", schemaRegistryUrl);
        Serde<GenericRecord> avroSerde = new GenericAvroSerde();
        avroSerde.configure(serdeConfig, isKey);
        return avroSerde;
    }
}
