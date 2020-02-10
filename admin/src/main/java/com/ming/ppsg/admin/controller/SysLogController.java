package com.ming.ppsg.admin.controller;


import com.ming.ppsg.admin.service.SysLogService;
import com.ming.ppsg.core.page.PageRequest;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 日志控制器
 * @author Louis
 * @date Oct 29, 2018
 */
@RestController
@RequestMapping("/admin/log")
public class SysLogController {

	@Resource
	private SysLogService sysLogService;

	@PreAuthorize("hasAuthority('sys:log:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysLogService.findPage(pageRequest));
	}
}
