package com.mitahcodegarage.kafkapublish.service;

import com.mitahcodegarage.kafkapublish.exceptions.KafkaGenericException;
import io.confluent.kafka.schemaregistry.ParsedSchema;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.rest.exceptions.RestClientException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

public class SchemaRegistryService {
    private static final Logger logger = LogManager.getLogger();

    private CachedSchemaRegistryClient client;

    public SchemaRegistryService(SchemaRegistryClient schemaRegistryClient) {
        if(schemaRegistryClient instanceof CachedSchemaRegistryClient) {
            this.client = (CachedSchemaRegistryClient) schemaRegistryClient;
        }
    }
    public int submitSchema(String subject, String schemaString) {
        logger.debug("Registering the schema [{}] to schema registry for subject [{}]", schemaString, subject);
        int registeredSchemaId = -1;
        try {
            Optional<ParsedSchema> optionalSchema = client.parseSchema("AVRO", schemaString, Collections.EMPTY_LIST);
            if(optionalSchema.isPresent()) {
                ParsedSchema schema = optionalSchema.get();
                registeredSchemaId = client.register(subject, schema);
            } else {
                throw new KafkaGenericException("Unable to parse the Schema");
            }
            logger.debug("Schema registered successfully");
        } catch (IOException | RestClientException e) {
            logger.error("Unable to register the schema");
            logger.error(e.getMessage());
            throw new KafkaGenericException("Unable to register the schema", e);
        }
        return registeredSchemaId;
    }
}
