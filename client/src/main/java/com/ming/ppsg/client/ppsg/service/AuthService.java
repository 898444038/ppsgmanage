package com.ming.ppsg.client.ppsg.service;

import com.ming.ppsg.client.ppsg.service.impl.AuthServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;

@FeignClient(name = "ppsg-server",fallback = AuthServiceHystrix.class)
public interface AuthService {

    @PostMapping("/auth/getToken")
    String getToken(@RequestBody Map<String,Object> map);

}
