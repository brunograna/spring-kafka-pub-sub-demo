package com.demo.kafkapubsub.service;

import com.demo.kafkapubsub.mocks.KafkaMock;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConsumerServiceTest {

    @Autowired
    private ConsumerService consumerService;

    @Nested
    class consumeFromFirstGroupId {
        @Test
        void shouldConsumeWithoutThrowException() {
            Assertions.assertDoesNotThrow(
                    () -> consumerService.consumeBackendUsNews(KafkaMock.consumeUserMessage(), KafkaMock.headers()));
        }

        @Test
        void shouldNotThrownExceptionWhenBodyIsInWrongFormat() {
            Assertions.assertDoesNotThrow(
                    () -> consumerService.consumeBackendBrazilNews("wrong message", KafkaMock.headers()));
        }
    }

}