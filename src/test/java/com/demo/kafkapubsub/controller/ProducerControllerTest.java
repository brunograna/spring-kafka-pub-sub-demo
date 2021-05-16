package com.demo.kafkapubsub.controller;

import com.demo.kafkapubsub.domain.Location;
import com.demo.kafkapubsub.domain.News;
import com.demo.kafkapubsub.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
                                                new HttpEntity<>(new News("title", Location.BRAZIL), this.getHeaders()),
                                                Object.class);

        assertEquals(result.getStatusCode(), HttpStatus.NO_CONTENT);
        assertNull(result.getBody());
    }

    @Test
    void shouldReceiveBadRequestWhenBodyIsNotSent() {
        var result = restTemplate.exchange(
                "/kafka/v1/producer",
                HttpMethod.POST,
                new HttpEntity<>(this.getHeaders()),
                Object.class);

        assertEquals(result.getStatusCode(), HttpStatus.BAD_REQUEST);
    }

    private HttpHeaders getHeaders() {
        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}