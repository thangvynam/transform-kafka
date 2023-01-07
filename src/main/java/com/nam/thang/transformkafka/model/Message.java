package com.nam.thang.transformkafka.model;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * @author : Nam Thang
 * @since : 07/01/2023, Sat
 **/
@Getter
@Service
public class Message implements Serializable {
    private String value;
}
