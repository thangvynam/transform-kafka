package com.nam.thang.transformkafka.producer.service;

import com.nam.thang.avro.orders.OrderValue;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
public interface ProducerService {

    void sendMessage(OrderValue orderValue);
}
