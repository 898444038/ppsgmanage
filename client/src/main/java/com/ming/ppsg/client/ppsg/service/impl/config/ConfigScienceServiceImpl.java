package com.ming.ppsg.client.ppsg.service.impl.config;

import java.util.Map;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Component;
import com.ming.ppsg.client.ppsg.service.config.ConfigScienceService;

@Component
public class ConfigScienceServiceImpl implements ConfigScienceService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	@PostMapping("/ppsg/config/science/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	@PostMapping("/ppsg/config/science/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	@PostMapping("/ppsg/config/science/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	@PostMapping("/ppsg/config/science/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

}

