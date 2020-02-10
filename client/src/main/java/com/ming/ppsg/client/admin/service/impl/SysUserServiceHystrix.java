package com.ming.ppsg.client.admin.service.impl;

import com.ming.ppsg.client.admin.service.SysUserService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Component
public class SysUserServiceHystrix implements SysUserService {

    @RequestMapping("/admin/user/list")
    public String list() {
        return "sorry, this service call failed.";
    }

}
