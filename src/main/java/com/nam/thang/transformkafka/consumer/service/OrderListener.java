package com.nam.thang.transformkafka.consumer.service;

import com.nam.thang.avro.orders.OrderValue;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Service
@Log4j2
public class OrderListener {

    @KafkaListener(topics = "${avro.topic.name}", containerFactory = "kafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, OrderValue> record, Acknowledgment acks) {
        log.info("Received Message in group: " + record.toString());
        acks.acknowledge();
    }
}
