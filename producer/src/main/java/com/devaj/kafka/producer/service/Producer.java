package com.devaj.kafka.producer.service;

import com.devaj.kafka.producer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * Created by antonio on 27/04/2020.
 */
@Service
@Slf4j
public class Producer {

    @Value("${order.topic}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

//    public void sendMessage(String message) {
//        log.info("#### -> Producing message -> " + message);
//        this.kafkaTemplate.send(TOPIC, message);
//    }

    public void sendMessage(User user) {
        log.info("#### -> Producing message -> " + user);
//        this.kafkaTemplate.send(TOPIC, user);
        Message<User> userMessage = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();

        kafkaTemplate.send(userMessage);
    }
}
