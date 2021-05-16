package com.demo.kafkapubsub.controller;

import com.demo.kafkapubsub.domain.News;
import com.demo.kafkapubsub.service.ProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka/v1/producer")
public class ProducerController {

    private final ProducerService producerService;

    public ProducerController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void publish(@RequestBody News news) throws JsonProcessingException {
        this.producerService.sendMessage(news);
    }
}
