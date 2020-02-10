package com.ming.ppsg.client.admin.service;

import com.ming.ppsg.client.admin.service.impl.SysUserServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ppsg-admin",fallback = SysUserServiceHystrix.class)
public interface SysUserService{

    @RequestMapping("/admin/user/list")
    String list();

}
