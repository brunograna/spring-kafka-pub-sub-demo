package com.demo.kafkapubsub.mocks;

import com.demo.kafkapubsub.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
