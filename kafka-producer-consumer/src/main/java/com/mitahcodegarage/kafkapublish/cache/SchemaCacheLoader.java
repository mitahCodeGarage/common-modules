package com.mitahcodegarage.kafkapublish.cache;

import com.google.common.cache.CacheLoader;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class SchemaCacheLoader extends CacheLoader<String, String> {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    SchemaRegistryClient schemaRegistryClient;

    @Override
    public String load(String s) throws Exception {
        logger.trace("Cache miss! Getting data from source");

        String[] inputs = s.split(":");
        if(inputs[1].equalsIgnoreCase("0")) {
            return schemaRegistryClient.getLatestSchemaMetadata(inputs[0]).getSchema();
        } else {
            return schemaRegistryClient.getSchemaMetadata(inputs[0], Integer.parseInt(inputs[1])).getSchema();
        }
    }
}
