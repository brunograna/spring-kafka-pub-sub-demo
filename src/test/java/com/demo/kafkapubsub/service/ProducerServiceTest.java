package com.demo.kafkapubsub.service;

import com.demo.kafkapubsub.mocks.NewsMock;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class ProducerServiceTest {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private KafkaTemplate<String, String> kafkaTemplate;

    @Captor
    private ArgumentCaptor<Message<String>> messageArgumentCaptor;

    @Nested
    class sendMessage {

        @Test
        void shouldSendWithSuccess() throws JsonProcessingException {
            var user = NewsMock.success();

            producerService.sendMessage(user);

            verify(kafkaTemplate, times(1)).send(messageArgumentCaptor.capture());

            var message = messageArgumentCaptor.getValue();

            assertNotNull(message);
            assertNotNull(message.getPayload());
            assertFalse(message.getPayload().isBlank());
            assertEquals(message.getPayload(), objectMapper.writeValueAsString(user));
        }
    }
}