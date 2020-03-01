package com.ming.ppsg.client.ppsg.controller.config;

import com.ming.ppsg.client.ppsg.service.config.ConfigGeneralsTypeService;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 武将类型配置
 * @author: wang
 * @date: 2020-02-29 16:29:53
 */
@RestController
@RequestMapping("/ppsg/config/generals/type")
public class ConfigGeneralsTypeController {

	@Resource
	private ConfigGeneralsTypeService configGeneralsTypeService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return configGeneralsTypeService.select(map);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return configGeneralsTypeService.insert(map);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return configGeneralsTypeService.update(map);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return configGeneralsTypeService.delete(map);
	}

}
