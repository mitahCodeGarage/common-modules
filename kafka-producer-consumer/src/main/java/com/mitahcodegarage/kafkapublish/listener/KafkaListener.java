package com.mitahcodegarage.kafkapublish.listener;

import org.apache.kafka.clients.consumer.Consumer;

import java.util.Arrays;

public class KafkaListener<V> {

    public void listen(Consumer consumer, String topic) {
        consumer.subscribe(Arrays.asList(topic));
    }
}
