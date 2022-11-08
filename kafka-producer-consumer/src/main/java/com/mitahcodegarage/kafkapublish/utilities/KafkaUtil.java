package com.mitahcodegarage.kafkapublish.utilities;

import java.util.Properties;

public class KafkaUtil {

    public static Properties createProducerProperties(String bootstrapServers, String keySerializer,
                                                      String valueSerializer, String schemaRegistryUrl) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("key.serializer", keySerializer);
        properties.put("value.serializer", valueSerializer);
        properties.put("schema.registry.url", schemaRegistryUrl);
        return properties;
    }

    public static Properties createConsumerProperties(String bootstrapServers, String keyDeserializer,
                                                      String valueDeserializer, String groupId, String schemaRegistryUrl) {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", bootstrapServers);
        properties.put("group.id", groupId);
        properties.put("key.deserializer", keyDeserializer);
        properties.put("value.deserializer", valueDeserializer);
        properties.put("schema.registry.url", schemaRegistryUrl);
        return properties;
    }
}
