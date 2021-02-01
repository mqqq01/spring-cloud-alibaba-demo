package com.gideon.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "micro-provider")
public interface MicroProviderFeign {

    @GetMapping("/echo/{message}")
    String echo(@PathVariable("message") String message);
}
