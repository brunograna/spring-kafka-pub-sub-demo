package com.demo.kafkapubsub.controller;

import com.demo.kafkapubsub.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProducerControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ProducerService producerService;

    @Test
    void shouldReceiveNoContentWhenPayloadIsValid() {
        var result = restTemplate.exchange(
                                                "/kafka/v1/producer",
                                                HttpMethod.POST,
                                                new HttpEntity<>("message", new HttpHeaders()),
                                                Object.class);

        assertEquals(result.getStatusCode(), HttpStatus.NO_CONTENT);
        assertNull(result.getBody());
    }

    @Test
    void shouldReceiveBadRequestWhenBodyIsNotSent() {
        var result = restTemplate.exchange(
                "/kafka/v1/producer",
                HttpMethod.POST,
                new HttpEntity<>(new HttpHeaders()),
                Object.class);

        assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}