package com.ming.ppsg.ppsg.controller.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.ppsg.entity.config.ConfigDict;
import com.ming.ppsg.ppsg.service.config.ConfigDictService;
import com.ming.ppsg.ppsg.vo.config.ConfigDictVo;

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
	public HttpResult select(@RequestBody ConfigDictVo configDictVo){
		List<ConfigDict> list = configDictService.select(configDictVo);
		return HttpResult.ok(list);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody ConfigDictVo configDictVo){
		int i = configDictService.insert(configDictVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody ConfigDictVo configDictVo){
		if(configDictVo.getId() == null){
			return HttpResult.error();
		}
		int i = configDictService.update(configDictVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody ConfigDictVo configDictVo){
		if(configDictVo.getId() == null){
			return HttpResult.error();
		}
		int i = configDictService.delete(configDictVo);
		return HttpResult.judge(i);
	}

}
