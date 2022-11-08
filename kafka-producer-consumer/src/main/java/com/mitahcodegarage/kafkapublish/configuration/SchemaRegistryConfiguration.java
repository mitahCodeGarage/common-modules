package com.mitahcodegarage.kafkapublish.configuration;

import com.mitahcodegarage.kafkapublish.service.SchemaRegistryService;
import io.confluent.kafka.schemaregistry.client.CachedSchemaRegistryClient;
import io.confluent.kafka.schemaregistry.client.SchemaRegistryClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:properties/kafka-stream.properties")
public class SchemaRegistryConfiguration {

    private static final Logger logger = LogManager.getLogger();

    @Value("${schema.registry.endpoint}")
    String endpoint;

    @Bean
    public SchemaRegistryClient schemaRegistryClient(@Value("${schema.registry.cacheCapacity:10}") int cacheCapacity){
        logger.debug("Initializing the schemaRegistry Client");
        CachedSchemaRegistryClient client = new CachedSchemaRegistryClient(endpoint, cacheCapacity);
        return client;
    }

    @Bean
    public SchemaRegistryService schemaRegistryService(SchemaRegistryClient schemaRegistryClient) {
        return new SchemaRegistryService(schemaRegistryClient);
    }
}
