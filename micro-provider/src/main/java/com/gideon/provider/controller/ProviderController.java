package com.gideon.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProviderController {

    @GetMapping("/provider")
    public String provider(){
        return "hello provider";
    }


    @GetMapping("/echo/{message}")
    public String echo(@PathVariable("message") String message){
        log.info("服务调用 message = {}", message);
        return "echo: " + message;
    }
}
