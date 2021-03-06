package com.ming.ppsg.client.ppsg.controller.config;

import java.util.Map;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.client.ppsg.service.config.ConfigStarService;

/**
 * 武将星级配置
 * @author: wang
 * @date: 2020-02-29 15:54:11
 */
@RestController
@RequestMapping("/ppsg/config/star")
public class ConfigStarController {

	@Resource
	private ConfigStarService configStarService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return configStarService.select(map);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return configStarService.insert(map);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return configStarService.update(map);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return configStarService.delete(map);
	}

}
