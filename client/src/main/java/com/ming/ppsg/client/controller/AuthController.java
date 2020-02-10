package com.ming.ppsg.client.controller;

import com.ming.ppsg.client.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/getToken")
    public String getToken(){
        return authService.getToken();
    }

}
