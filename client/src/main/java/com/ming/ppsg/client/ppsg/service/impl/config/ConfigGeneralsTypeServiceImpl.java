package com.ming.ppsg.client.ppsg.service.impl.config;

import com.ming.ppsg.client.ppsg.service.config.ConfigGeneralsTypeService;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Component
public class ConfigGeneralsTypeServiceImpl implements ConfigGeneralsTypeService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@Override
	@PostMapping("/ppsg/config/generals/type/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@Override
	@PostMapping("/ppsg/config/generals/type/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@Override
	@PostMapping("/ppsg/config/generals/type/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:29:53
	 */
	@Override
	@PostMapping("/ppsg/config/generals/type/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

}

