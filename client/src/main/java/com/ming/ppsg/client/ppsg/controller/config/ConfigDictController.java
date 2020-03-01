package com.ming.ppsg.client.ppsg.controller.config;

import java.util.Map;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.client.ppsg.service.config.ConfigDictService;

/**
 * 数据字典配置
 * @author: wang
 * @date: 2020-02-29 16:42:32
 */
@RestController
@RequestMapping("/ppsg/config/dict")
public class ConfigDictController {

	@Resource
	private ConfigDictService configDictService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return configDictService.select(map);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return configDictService.insert(map);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return configDictService.update(map);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return configDictService.delete(map);
	}

}
