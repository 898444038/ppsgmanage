package com.ming.ppsg.client.admin.service.impl;

import com.ming.ppsg.client.admin.service.SysLoginService;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
public class SysLoginServiceHystrix implements SysLoginService {

    @PostMapping("/admin/login")
    public HttpResult login(@RequestBody Map<String,Object> map) {
        return HttpResult.error();
    }

}
