package com.mitahcodegarage.kafkapublish.factory;

import com.mitahcodegarage.kafkapublish.exceptions.ConsumerNotFoundException;
import com.mitahcodegarage.kafkapublish.utilities.KafkaUtil;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConsumerFactory {

    String bootstrapServers;
    String keyDeserializer;
    String valueDeserializer;
    String groupId;
    String schemaRegistryUrl;

    public ConsumerFactory(String bootstrapServers, String keyDeserializer, String valueDeserializer, String groupId, String schemaRegistryUrl){
        this.bootstrapServers = bootstrapServers;
        this.keyDeserializer = keyDeserializer; this.valueDeserializer = valueDeserializer;
        this.groupId = groupId; this.schemaRegistryUrl = schemaRegistryUrl;
    }

    private Map<String, KafkaConsumer> consumers = new HashMap<>();

    public KafkaConsumer createConsumer(String consumerName) {

        KafkaConsumer consumer = new KafkaConsumer<>(loadProperties());
        consumers.put(consumerName, consumer);
        return consumer;
    }

    public KafkaConsumer createConsumer(String consumerName, Properties properties) {

        KafkaConsumer consumer = new KafkaConsumer<>(properties);
        consumers.put(consumerName, consumer);
        return consumer;
    }

    public KafkaConsumer getOrCreateConsumerIfAbsent(String consumerName) {
        KafkaConsumer consumer = consumers.get(consumerName);
        if(null == consumer) {
            return createConsumer(consumerName);
        }
        return consumer;
    }

    public KafkaConsumer getConsumer(String consumerName) {
        KafkaConsumer consumer = consumers.get(consumerName);
        if(null == consumer){
            throw new ConsumerNotFoundException("The consumerName " + consumerName + " is not loaded");
        }
        return consumer;
    }

    private Properties loadProperties() {
        return KafkaUtil.createConsumerProperties(bootstrapServers, keyDeserializer, valueDeserializer, groupId, schemaRegistryUrl);
    }
}
