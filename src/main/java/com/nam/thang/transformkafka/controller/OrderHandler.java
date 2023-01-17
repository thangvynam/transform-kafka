package com.nam.thang.transformkafka.controller;

import com.nam.thang.avro.orders.OrderValue;
import com.nam.thang.transformkafka.model.Order;
import com.nam.thang.transformkafka.producer.service.ProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import static com.nam.thang.transformkafka.controller.OrderHandler.BASE_URI;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Log4j2
@RestController
@RequestMapping(BASE_URI + "/order")
public class OrderHandler {
    public final static String BASE_URI = "api/v1";

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = "", method = POST, produces = "application/json")
    @ResponseBody
    public String sendOrder(@RequestBody Order order) {
        log.info("sendOrder {}", order.toString());
        OrderValue orderValue = OrderValue.newBuilder()
                .setId(order.getId())
                .setAmount(order.getAmount())
                .setCreditcard(order.getCreditcard())
                .setCustomer(order.getCustomer())
                .setCreated(LocalDateTime.now())
                .build();
        producerService.sendMessage(orderValue);
        return orderValue.toString();
    }
}
