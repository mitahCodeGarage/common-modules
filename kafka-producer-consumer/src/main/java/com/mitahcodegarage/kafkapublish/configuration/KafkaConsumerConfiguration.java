package com.mitahcodegarage.kafkapublish.configuration;

import com.mitahcodegarage.kafkapublish.factory.ConsumerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConsumerConfiguration {

    @Value("${bootstrap.servers}")
    String bootstrapServers;

    @Value("${batch.key.deserializer:org.apache.kafka.common.serialization.StringDeserializer}")
    String keyDeserializer;

    @Value("${batch.value.deserializer:org.apache.kafka.common.serialization.StringDeserializer}")
    String valueDeserializer;

    @Value("${group.id}")
    String groupId;

    @Value("${schema.registry.endpoint}")
    String schemaRegistryUrl;

    @Bean
    public ConsumerFactory consumerFactory() {
        return new ConsumerFactory(bootstrapServers, keyDeserializer, valueDeserializer, groupId, schemaRegistryUrl);
    }
}
