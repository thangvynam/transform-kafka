package com.nam.thang.transformkafka.controller;

import com.nam.thang.transformkafka.model.Message;
import com.nam.thang.transformkafka.producer.service.ProducerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.nam.thang.transformkafka.controller.MessageHandler.BASE_URI;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Log4j2
@RestController
@RequestMapping(BASE_URI + "/message")
public class MessageHandler {
    public final static String BASE_URI = "api/v1";

    @Autowired
    private  ProducerService producerService;

    @RequestMapping(value = "", method = POST, produces = "application/json")
    @ResponseBody
    public String sendMessage(@RequestBody Message message) {
        log.info("sendMessage {}", message);
        var value = message.getValue();
        producerService.sendMessage(value);
        return value;
    }
}
