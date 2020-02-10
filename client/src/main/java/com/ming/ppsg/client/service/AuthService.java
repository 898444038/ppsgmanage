package com.ming.ppsg.client.service;

import com.ming.ppsg.client.service.impl.AuthServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ppsg-server",fallback = AuthServiceHystrix.class)
public interface AuthService {

    @RequestMapping("/getToken")
    String getToken();

}
