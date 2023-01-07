package com.nam.thang.transformkafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Service
public class MessageEventListener {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${kafka.group-id}")
    public void receiveMessage(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
