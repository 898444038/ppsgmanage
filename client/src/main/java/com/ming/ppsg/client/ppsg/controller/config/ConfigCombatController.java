package com.ming.ppsg.client.ppsg.controller.config;

import java.util.Map;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.client.ppsg.service.config.ConfigCombatService;

/**
 * 战力配置
 * @author: wang
 * @date: 2020-02-29 15:54:11
 */
@RestController
@RequestMapping("/ppsg/config/combat")
public class ConfigCombatController {

	@Resource
	private ConfigCombatService configCombatService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return configCombatService.select(map);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return configCombatService.insert(map);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return configCombatService.update(map);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return configCombatService.delete(map);
	}

}
