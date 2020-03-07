package com.ming.ppsg.client.ppsg.service.impl;

import com.ming.ppsg.client.ppsg.service.XzlService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
public class XzlServiceHystrix implements XzlService {

    @Override
    @PostMapping("/ppsg/xzl/custom/exportExcel")
    public void exportExcel(@RequestBody Map<String,Object> map) {
        //return HttpResult.error("sorry, this service call failed.");
    }

}
