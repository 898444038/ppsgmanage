package com.ming.ppsg.client.ppsg.controller;

import com.ming.ppsg.client.ppsg.service.XzlService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/ppsg/xzl/custom")
public class XzlController {

    @Resource
    private XzlService xzlService;

    @PostMapping("/exportExcel")
    public void exportExcel(@RequestBody Map<String,Object> map){
        xzlService.exportExcel(map);
    }

}
