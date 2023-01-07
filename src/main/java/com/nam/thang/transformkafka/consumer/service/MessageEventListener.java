package com.nam.thang.transformkafka.consumer.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Service
@Log4j2
public class MessageEventListener {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group-id}")
    public void receiveMessage(String message) {
        log.info("Received Message in group foo: " + message);
    }
}
