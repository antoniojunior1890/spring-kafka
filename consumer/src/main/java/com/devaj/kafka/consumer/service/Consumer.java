package com.devaj.kafka.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by antonio on 27/04/2020.
 */
@Service
@Slf4j
public class Consumer {

    @KafkaListener(topics = "${order.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) throws IOException {
        log.info("#### -> Consumed message -> " + message);
    }
}
