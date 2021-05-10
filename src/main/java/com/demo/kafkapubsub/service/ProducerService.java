package com.demo.kafkapubsub.service;

import com.demo.kafkapubsub.config.AppConfig;
import com.demo.kafkapubsub.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public ProducerService(final KafkaTemplate<String, String> kafkaTemplate,
                           final ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendMessage(User user) throws JsonProcessingException {
        var message = this.objectMapper.writeValueAsString(user);

        logger.info("Message sent -> {}", message);

        this.kafkaTemplate.send(MessageBuilder.withPayload(message)
                                    .setHeader(KafkaHeaders.TOPIC, AppConfig.TOPIC_NAME)
                                    .setHeader("x-application-name", "kafka-pub-sub")
                                    .build());
    }
}
