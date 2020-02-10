package com.ming.ppsg.client.admin.controller;

import com.ming.ppsg.client.admin.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin/user")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    @RequestMapping("/list")
    public String list(){
        return sysUserService.list();
    }

}
