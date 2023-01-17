package com.nam.thang.transformkafka.consumer.config;

import com.nam.thang.avro.orders.OrderValue;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

import static org.springframework.kafka.listener.ContainerProperties.AckMode.MANUAL;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Configuration
public class KafkaConsumerConfig {

    @Bean
    public ConsumerFactory<String, OrderValue> consumerFactory(KafkaProperties kafkaProperties) {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, OrderValue>> kafkaListenerContainerFactory(KafkaProperties kafkaProperties) {
        ConcurrentKafkaListenerContainerFactory<String, OrderValue> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.getContainerProperties().setAckMode(MANUAL);
        factory.setConsumerFactory(consumerFactory(kafkaProperties));
        return factory;
    }
}
