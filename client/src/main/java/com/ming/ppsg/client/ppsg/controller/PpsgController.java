package com.ming.ppsg.client.ppsg.controller;

import com.ming.ppsg.client.ppsg.service.PpsgService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PpsgController {
    @Resource
    private PpsgService ppsgService;

    @RequestMapping("/admin/list")
    public String list(){
        return ppsgService.list();
    }
}
