package com.ming.ppsg.client.controller;

import com.ming.ppsg.client.service.FeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class FeignController {
    @Resource
    private FeignService feignService;

    @RequestMapping("/feign/call")
    public String call() {
        // 像调用本地服务一样
        return feignService.hello();
    }

    @RequestMapping("/api/auth/login")
    public String call2() {
        // 像调用本地服务一样
        return feignService.hello();
    }
}
