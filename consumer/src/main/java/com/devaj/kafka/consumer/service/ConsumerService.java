package com.devaj.kafka.consumer.service;

import com.devaj.kafka.consumer.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * Created by antonio on 27/04/2020.
 */
@Service
@Slf4j
public class ConsumerService {

    @KafkaListener(topics = "${order.topic}") //, groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload User data,
                        @Headers MessageHeaders headers) {

        log.info("#### -> Consumed message -> " + data);

        headers.keySet().forEach(key -> {
            log.info("{}: {}", key, headers.get(key));
        });
    }

}