package com.mitahcodegarage.kafkapublish.configuration;

import com.mitahcodegarage.kafkapublish.factory.ProducerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:properties/kafka.properties")
public class KafkaProducerConfiguration {

    @Value("${bootstrap.servers}")
    String bootstrapServers;

    @Value("${batch.key.serializer:org.apache.kafka.common.serialization.StringSerializer}")
    String batchKeySerializer;

    @Value("${batch.value.serializer:org.apache.kafka.common.serialization.StringSerializer}")
    String batchValueSerializer;

    @Value("${status.key.serializer:org.apache.kafka.common.serialization.StringSerializer}")
    String statusKeySerializer;

    @Value("${status.value.serializer:org.apache.kafka.common.serialization.StringSerializer}")
    String statusValueSerializer;

    @Value("${schema.registry.endpoint}")
    String schemaRegistryUrl;

    @Bean
    public ProducerFactory producerFactoryBean() {
        return new ProducerFactory(bootstrapServers, batchKeySerializer, batchValueSerializer,
                statusKeySerializer, statusValueSerializer, schemaRegistryUrl);
    }
}
