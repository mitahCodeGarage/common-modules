package com.mitahcodegarage.kafkapublish.publishers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mitahcodegarage.models.BatchStatusRecord;
import org.apache.kafka.clients.producer.Producer;

import java.util.concurrent.ExecutionException;

public class KafkaBatchStatusPublisher extends KafkaPublisher<String> {

    public void publish(Producer producer, String topic, BatchStatusRecord message) throws ExecutionException, InterruptedException, JsonProcessingException {
        message.setLastModifiedOn(System.currentTimeMillis());
        super.publish(producer, topic, message.asJson());
    }
}
