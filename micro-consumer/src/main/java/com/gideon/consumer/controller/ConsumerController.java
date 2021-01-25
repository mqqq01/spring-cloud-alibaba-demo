package com.gideon.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer")
    public String consumer(){
        return "hello consumer";
    }

    @GetMapping("/discoveryClient")
    public String discoveryClient(){
        List<ServiceInstance> instances = discoveryClient.getInstances("micro-provider");

        return JSONObject.toJSONString(instances);
    }
}
