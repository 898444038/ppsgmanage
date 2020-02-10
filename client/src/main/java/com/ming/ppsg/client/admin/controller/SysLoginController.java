package com.ming.ppsg.client.admin.controller;

import com.ming.ppsg.client.admin.service.SysLoginService;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class SysLoginController {

    @Resource
    private SysLoginService sysLoginService;

    @PostMapping("/login")
    public HttpResult login(@RequestBody Map<String,Object> map){
        return sysLoginService.login(map);
    }

}
