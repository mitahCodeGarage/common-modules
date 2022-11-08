package com.mitahcodegarage.kafkapublish.publishers;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class KafkaPublisher<V> {

    public void publish(Producer producer, String topic, V message) throws ExecutionException, InterruptedException {
        RecordMetadata recordMetadata =  (RecordMetadata) producer.send(new ProducerRecord<>(topic, message)).get();
    }
}
