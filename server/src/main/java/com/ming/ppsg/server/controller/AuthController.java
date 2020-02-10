package com.ming.ppsg.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/getToken")
    public String getToken(@RequestBody Map<String,Object> map) {
        // 登录成功会返回Token给用户
        return map.toString();
    }

}