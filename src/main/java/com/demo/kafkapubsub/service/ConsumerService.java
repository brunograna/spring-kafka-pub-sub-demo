package com.demo.kafkapubsub.service;

import com.demo.kafkapubsub.config.AppConfig;
import com.demo.kafkapubsub.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    private final ObjectMapper objectMapper;

    public ConsumerService(final ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = AppConfig.TOPIC_NAME, groupId = AppConfig.FIRST_GROUP_ID)
    public void consumeFromFirstGroupId(String message, @Headers Map<String, String> headers) {
        try {
            var user = this.objectMapper.readValue(message, User.class);

            logger.info("=============== FIRST GROUP ID =================");
            logger.info("Message received as JSON -> {}", message);
            logger.info("Message received as Object -> {}", user);
            logger.info("Headers received -> {}", headers);
            logger.info("=============== FIRST GROUP ID =================");

        } catch (JsonProcessingException e) {
            logger.error("=============== FAILURE FIRST GROUP ID =================");
            logger.error("Consume failed for JSON -> {}", message);
            logger.error("Details: {}", e.getMessage());
            logger.error("=============== FAILURE FIRST GROUP ID =================");
        }
    }
}
