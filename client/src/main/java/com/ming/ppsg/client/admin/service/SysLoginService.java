package com.ming.ppsg.client.admin.service;

import com.ming.ppsg.client.admin.service.impl.SysLoginServiceHystrix;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "ppsg-admin",fallback = SysLoginServiceHystrix.class)
public interface SysLoginService{

    @PostMapping("/admin/login")
    public HttpResult login(@RequestBody Map<String,Object> map);

}
