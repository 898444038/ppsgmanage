package com.ming.ppsg.client.service;

import com.ming.ppsg.client.service.impl.AuthServiceHystrix;
import com.ming.ppsg.client.service.impl.PpsgServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ppsg-server",fallback = PpsgServiceHystrix.class)
public interface PpsgService {
    @RequestMapping("/list")
    String list();
}
