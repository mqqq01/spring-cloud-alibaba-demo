package com.gideon.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/call/echo/{message}")
    public String callEcho(@PathVariable String message) {
        // 访问应用 micro-provider 的 REST "/echo/{message}"
//        return restTemplate.getForObject("http://127.0.0.1:9001/echo/" + message, String.class);
        return restTemplate.getForObject("http://micro-provider/echo/" + message, String.class);
    }

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
