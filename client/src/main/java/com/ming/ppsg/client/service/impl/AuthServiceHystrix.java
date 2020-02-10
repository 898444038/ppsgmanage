package com.ming.ppsg.client.service.impl;

import com.ming.ppsg.client.service.AuthService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class AuthServiceHystrix implements AuthService {

    @RequestMapping("/getToken")
    public String getToken() {
        return "sorry, this service call failed.";
    }

}
