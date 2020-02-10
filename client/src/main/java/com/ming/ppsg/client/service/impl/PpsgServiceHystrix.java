package com.ming.ppsg.client.service.impl;

import com.ming.ppsg.client.service.PpsgService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
public class PpsgServiceHystrix implements PpsgService {
    @RequestMapping("/list")
    public String list() {
        return "sorry, this service call failed. list";
    }
}
