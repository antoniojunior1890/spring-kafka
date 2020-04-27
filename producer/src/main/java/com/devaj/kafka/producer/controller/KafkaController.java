package com.devaj.kafka.producer.controller;

import com.devaj.kafka.producer.model.User;
import com.devaj.kafka.producer.service.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by antonio on 27/04/2020.
 */
@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody User user) {
        this.producer.sendMessage(user);
    }
}
