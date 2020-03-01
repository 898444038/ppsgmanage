package com.ming.ppsg.ppsg.controller.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.ppsg.entity.config.ConfigCombat;
import com.ming.ppsg.ppsg.service.config.ConfigCombatService;
import com.ming.ppsg.ppsg.vo.config.ConfigCombatVo;

/**
 * 战力配置
 * @author: wang
 * @date: 2020-02-29 14:43:00
 */
@RestController
@RequestMapping("/ppsg/config/combat")
public class ConfigCombatController {

	@Resource
	private ConfigCombatService configCombatService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody ConfigCombatVo configCombatVo){
		List<ConfigCombat> list = configCombatService.select(configCombatVo);
		return HttpResult.ok(list);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody ConfigCombatVo configCombatVo){
		int i = configCombatService.insert(configCombatVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody ConfigCombatVo configCombatVo){
		if(configCombatVo.getId() == null){
			return HttpResult.error();
		}
		int i = configCombatService.update(configCombatVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody ConfigCombatVo configCombatVo){
		if(configCombatVo.getId() == null){
			return HttpResult.error();
		}
		int i = configCombatService.delete(configCombatVo);
		return HttpResult.judge(i);
	}

}
