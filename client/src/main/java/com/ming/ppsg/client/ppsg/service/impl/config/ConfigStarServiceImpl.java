package com.ming.ppsg.client.ppsg.service.impl.config;

import java.util.Map;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Component;
import com.ming.ppsg.client.ppsg.service.config.ConfigStarService;

@Component
public class ConfigStarServiceImpl implements ConfigStarService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@Override
	@PostMapping("/ppsg/config/star/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@Override
	@PostMapping("/ppsg/config/star/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@Override
	@PostMapping("/ppsg/config/star/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@Override
	@PostMapping("/ppsg/config/star/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

}

