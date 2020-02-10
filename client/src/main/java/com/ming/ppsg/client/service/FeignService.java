package com.ming.ppsg.client.service;

import com.ming.ppsg.client.service.impl.FeignHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ppsg-server",fallback = FeignHystrix.class)
public interface FeignService {
    @RequestMapping("/hello")
    public String hello();
}
