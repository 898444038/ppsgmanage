package com.ming.ppsg.ppsg.controller.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.ppsg.entity.config.ConfigScience;
import com.ming.ppsg.ppsg.service.config.ConfigScienceService;
import com.ming.ppsg.ppsg.vo.config.ConfigScienceVo;

/**
 * 科技配置
 * @author: wang
 * @date: 2020-02-29 17:06:03
 */
@RestController
@RequestMapping("/ppsg/config/science")
public class ConfigScienceController {

	@Resource
	private ConfigScienceService configScienceService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody ConfigScienceVo configScienceVo){
		List<ConfigScience> list = configScienceService.select(configScienceVo);
		return HttpResult.ok(list);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody ConfigScienceVo configScienceVo){
		int i = configScienceService.insert(configScienceVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody ConfigScienceVo configScienceVo){
		if(configScienceVo.getId() == null){
			return HttpResult.error();
		}
		int i = configScienceService.update(configScienceVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody ConfigScienceVo configScienceVo){
		if(configScienceVo.getId() == null){
			return HttpResult.error();
		}
		int i = configScienceService.delete(configScienceVo);
		return HttpResult.judge(i);
	}

}
