package com.mitahcodegarage.kafkapublish.publishers;

import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.concurrent.ExecutionException;

public class KafkaMessagePublisher extends KafkaPublisher<String> {

    @Override
    public void publish(Producer producer, String topic, String message) throws ExecutionException, InterruptedException {
        RecordMetadata recordMetadata =  (RecordMetadata) producer.send(new ProducerRecord<>(topic, message)).get();
    }
}
