package com.gideon.consumer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @GetMapping("/consumer")
    public String consumer(){
        return "hello consumer";
    }
}
