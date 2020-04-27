package com.devaj.kafka.producer.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by antonio on 27/04/2020.
 */
@Service
@Slf4j
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    @Value("${order.topic}")
    private String TOPIC;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("#### -> Producing message -> " + message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
