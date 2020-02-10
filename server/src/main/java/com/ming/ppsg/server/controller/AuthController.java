package com.ming.ppsg.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @RequestMapping("/getToken")
    public String getToken(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        // 登录成功会返回Token给用户
        return user.toString();
    }

}