package com.demo.kafkapubsub.mocks;

import org.springframework.kafka.support.KafkaHeaders;

import java.util.Map;

public class KafkaMock {

    public static String consumeUserMessage() {
        return "{\"name\":\"random\"}";
    }

    public static Map<String, String> headers() {
        return Map.of(
                KafkaHeaders.TOPIC, "t-random-topic"
        );
    }
}
