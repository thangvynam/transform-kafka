package com.nam.thang.transformkafka.consumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Service
public class MessageEventListener {

    @KafkaListener(topics = "my-topic-1", groupId = "nam-thang-consumer-group-1")
    public void receiveMessage(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
