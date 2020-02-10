package com.ming.ppsg.client.ppsg.controller;

import com.ming.ppsg.client.ppsg.service.AuthService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/getToken")
    public String getToken(@RequestBody Map<String,Object> map){
        return authService.getToken(map);
    }

}
