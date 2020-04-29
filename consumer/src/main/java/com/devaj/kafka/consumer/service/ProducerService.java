package com.devaj.kafka.consumer.service;

import lombok.extern.slf4j.Slf4j;
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
public class ProducerService {

    @Value("${topic.processed}")
    private String TOPIC_RESPONSE;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        log.info("#### -> Consumer response -> " + message);
        Message<String> userMessage = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, TOPIC_RESPONSE)
                .build();

        kafkaTemplate.send(userMessage);
    }
}
