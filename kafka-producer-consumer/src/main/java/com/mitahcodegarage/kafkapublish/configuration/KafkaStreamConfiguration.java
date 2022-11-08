package com.mitahcodegarage.kafkapublish.configuration;

import com.google.common.cache.LoadingCache;
import com.mitahcodegarage.kafkapublish.service.GenericRecordService;
import com.mitahcodegarage.kafkapublish.service.GenericSerdeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:properties/kafka-stream.properties")
@Import(value = {com.mitahcodegarage.kafkapublish.configuration.SchemaRegistryConfiguration.class,
        com.mitahcodegarage.kafkapublish.configuration.CacheConfiguration.class,
        com.mitahcodegarage.kafkapublish.cache.SchemaCacheLoader.class})
public class KafkaStreamConfiguration {

    private static final Logger logger = LogManager.getLogger();

    @Value("${schema.registry.endpoint}")
    String endpoint;

    @Bean
    public GenericRecordService genericRecordService(LoadingCache<String, String> schemaRegistryCache) {
        return new GenericRecordService(schemaRegistryCache);
    }

    @Bean
    public GenericSerdeService genericSerdeService() {
        return new GenericSerdeService(endpoint);
    }
}
