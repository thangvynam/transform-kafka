package com.nam.thang.transformkafka.producer.service;

import com.nam.thang.avro.orders.OrderValue;
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

    @Value(value = "${avro.topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, OrderValue> kafkaTemplate;

    @Override
    public void sendMessage(OrderValue orderValue) {
        kafkaTemplate.send(topicName, orderValue.getId(), orderValue);
    }
}
