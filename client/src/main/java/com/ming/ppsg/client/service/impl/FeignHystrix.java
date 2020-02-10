package com.ming.ppsg.client.service.impl;

import com.ming.ppsg.client.service.FeignService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class FeignHystrix implements FeignService {
    @RequestMapping("/hello")
    public String hello() {
        return "sorry, this service call failed.";
    }
}
