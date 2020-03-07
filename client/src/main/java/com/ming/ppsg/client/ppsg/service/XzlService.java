package com.ming.ppsg.client.ppsg.service;


import com.ming.ppsg.client.ppsg.service.impl.XzlServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "ppsg-server",fallback = XzlServiceHystrix.class)
public interface XzlService {

    @PostMapping("/ppsg/xzl/custom/exportExcel")
    public void exportExcel(@RequestBody Map<String,Object> map);
}
