package com.ming.ppsg.client.ppsg.service.impl;

import com.ming.ppsg.client.ppsg.service.AuthService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Component
public class AuthServiceHystrix implements AuthService {

    @PostMapping("/auth/getToken")
    public String getToken(Map<String,Object> map) {
        return "sorry, this service call failed.";
    }

}
