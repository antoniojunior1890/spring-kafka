package com.devaj.kafka.producer.controller;

import com.devaj.kafka.producer.model.User;
import com.devaj.kafka.producer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by antonio on 27/04/2020.
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final ProducerService producerService;

    @Autowired
    KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        producerService.sendMessage(user);
    }
}
