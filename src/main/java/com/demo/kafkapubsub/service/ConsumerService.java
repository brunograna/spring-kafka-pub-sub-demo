package com.demo.kafkapubsub.service;

import com.demo.kafkapubsub.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ConsumerService {

    private static final Logger logger = LoggerFactory.getLogger(ConsumerService.class);

    @KafkaListener(
            topicPartitions = { @TopicPartition(
                    topic = AppConfig.NEWS_CREATED_TOPIC_NAME,
                    partitions = {
                            AppConfig.NEWS_CREATED_BRAZIL_PARTITION,
                            AppConfig.NEWS_CREATED_INTERNATIONAL_PARTITION
                    })
            },
            groupId = AppConfig.BACKEND_CONSUMER_GROUP)
    public void consumeBackendBrazilNews(String message, @Headers Map<String, String> headers) {
        logger.info("BACKEND - BRAZIL NEWS - Message received as JSON -> {}", message);
    }

    @KafkaListener(
            topicPartitions = { @TopicPartition(
                    topic = AppConfig.NEWS_CREATED_TOPIC_NAME,
                    partitions = {
                            AppConfig.NEWS_CREATED_US_PARTITION,
                            AppConfig.NEWS_CREATED_INTERNATIONAL_PARTITION
                    })
            },
            groupId = AppConfig.BACKEND_CONSUMER_GROUP)
    public void consumeBackendUsNews(String message, @Headers Map<String, String> headers) {
        logger.info("BACKEND - US NEWS - Message received as JSON -> {}", message);
    }

    @KafkaListener(
            topicPartitions = { @TopicPartition(
                    topic = AppConfig.NEWS_CREATED_TOPIC_NAME,
                    partitions = {
                            AppConfig.NEWS_CREATED_BRAZIL_PARTITION,
                            AppConfig.NEWS_CREATED_INTERNATIONAL_PARTITION
                    })
            },
            groupId = AppConfig.MOBILE_CONSUMER_GROUP)
    public void consumeMobileBrazilNews(String message, @Headers Map<String, String> headers) {
        logger.info("MOBILE - BRAZIL NEWS - Message received as JSON -> {}", message);
    }

    @KafkaListener(
            topicPartitions = { @TopicPartition(
                    topic = AppConfig.NEWS_CREATED_TOPIC_NAME,
                    partitions = {
                            AppConfig.NEWS_CREATED_US_PARTITION,
                            AppConfig.NEWS_CREATED_INTERNATIONAL_PARTITION
                    })
            },
            groupId = AppConfig.MOBILE_CONSUMER_GROUP)
    public void consumeMobileUsNews(String message, @Headers Map<String, String> headers) {
        logger.info("MOBILE - US NEWS - Message received as JSON -> {}", message);
    }
}
