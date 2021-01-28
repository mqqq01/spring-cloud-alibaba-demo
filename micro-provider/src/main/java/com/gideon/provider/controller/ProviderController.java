package com.gideon.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ProviderController {

    @Value("${server.port}")
    private String port ;

    @GetMapping("/provider")
    public String provider(){
        return "hello provider";
    }


    @GetMapping("/echo/{message}")
    public String echo(@PathVariable("message") String message){
        log.info("服务调用 message = {}", message);
        return port + " echo: " + message;
    }
}
