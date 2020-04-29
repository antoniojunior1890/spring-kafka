package com.devaj.kafka.producer.service;

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

    @KafkaListener(topics = "${topic.processed}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(@Payload String data,
                        @Headers MessageHeaders headers) {

        log.info("#### -> Producer response -> " + data);

//        headers.keySet().forEach(key -> {
//            log.info("{}: {}", key, headers.get(key));
//        });
    }

}
