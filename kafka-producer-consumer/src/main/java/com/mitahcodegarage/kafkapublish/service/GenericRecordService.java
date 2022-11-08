package com.mitahcodegarage.kafkapublish.service;

import com.google.common.cache.LoadingCache;
import com.mitahcodegarage.kafkapublish.exceptions.KafkaGenericException;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.generic.GenericRecordBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.ExecutionException;

public class GenericRecordService {

    private static final Logger logger = LogManager.getLogger();

    private LoadingCache<String, String> schemaRegistryCache;

    public GenericRecordService(LoadingCache<String, String> schemaRegistryCache) {
        logger.trace("Registering the schema registry.");
        this.schemaRegistryCache = schemaRegistryCache;
    }

    public GenericRecord createGenericRecordForSubject(String subject) {
        return createGenericRecordForSubject(subject, 0);
    }

    public GenericRecord createGenericRecordForSubject(String subject, int schemaVersion) {
        logger.trace("Creating a generic record for the subject {} and version {}", subject, schemaVersion);

        GenericRecord finalrecordskey = null;
        try {
            logger.trace("Fetching latest schema for subject {}", subject);
            Schema schema = null;
            schema = new Schema.Parser().parse(schemaRegistryCache.get(subject + ":" + schemaVersion));

            logger.trace("Schema received {}", schema);

            finalrecordskey = new GenericRecordBuilder(schema).build();
        } catch (ExecutionException e) {
            logger.error("Unable to fetch the schema from schema registry");
            logger.error(e.getMessage());
            throw new KafkaGenericException("Unable to fetch the schema from schema registry", e);
        }
        return finalrecordskey;
    }
}
