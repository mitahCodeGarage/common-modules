package com.mitahcodegarage.kafkapublish.factory;

//import com.mitahcodegarage.kafkapublish.exceptions.ProducerNotFoundException;
import com.mitahcodegarage.kafkapublish.utilities.KafkaUtil;
import org.apache.kafka.clients.producer.KafkaProducer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ProducerFactory {

    String bootstrapServers;
    String batchKeySerializer;
    String batchValueSerializer;
    String statusKeySerializer;
    String statusValueSerializer;
    String schemaRegistryUrl;

    public ProducerFactory(String bootstrapServers, String batchKeySerializer, String batchValueSerializer,
                           String statusKeySerializer, String statusValueSerializer, String schemaRegistryUrl) {
        this.bootstrapServers = bootstrapServers;
        this.batchKeySerializer = batchKeySerializer; this.batchValueSerializer = batchValueSerializer;
        this.statusKeySerializer = statusKeySerializer; this.statusValueSerializer = statusValueSerializer;
        this.schemaRegistryUrl = schemaRegistryUrl;
    }

    private Map<String, KafkaProducer> producers = new HashMap<>();

    public KafkaProducer createProducer(String producerName, boolean isBatch) {
        KafkaProducer producer;
        if(isBatch) {
            producer = new KafkaProducer<>(loadBatchProperties());
        } else {
            producer = new KafkaProducer<>(loadStatusProperties());
        }
        producers.put(producerName, producer);
        return producer;
    }

    public KafkaProducer getOrCreateProducerIfAbsent(String producerName, boolean isBatch) {
        KafkaProducer producer = producers.get(producerName);
        if(null == producer) {
            return createProducer(producerName, isBatch);
        }
        return producer;
    }

    private Properties loadBatchProperties() {
        return KafkaUtil.createProducerProperties(bootstrapServers, batchKeySerializer, batchValueSerializer, schemaRegistryUrl);
    }

    private Properties loadStatusProperties() {
        return KafkaUtil.createProducerProperties(bootstrapServers, statusKeySerializer, statusValueSerializer, schemaRegistryUrl);
    }
}
