package com.nam.thang.transformkafka.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Service
public class DefaultProducerService implements ProducerService {

    @Value(value = "${kafka.topic}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(topicName, message);
    }
}
