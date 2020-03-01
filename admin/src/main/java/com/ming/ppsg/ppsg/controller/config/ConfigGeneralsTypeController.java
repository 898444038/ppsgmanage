package com.ming.ppsg.ppsg.controller.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.ppsg.entity.config.ConfigGeneralsType;
import com.ming.ppsg.ppsg.service.config.ConfigGeneralsTypeService;
import com.ming.ppsg.ppsg.vo.config.ConfigGeneralsTypeVo;

/**
 * 武将类型配置
 * @author: wang
 * @date: 2020-02-29 16:34:16
 */
@RestController
@RequestMapping("/ppsg/config/generals/type")
public class ConfigGeneralsTypeController {

	@Resource
	private ConfigGeneralsTypeService configGeneralsTypeService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody ConfigGeneralsTypeVo configGeneralsTypeVo){
		List<ConfigGeneralsType> list = configGeneralsTypeService.select(configGeneralsTypeVo);
		return HttpResult.ok(list);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody ConfigGeneralsTypeVo configGeneralsTypeVo){
		int i = configGeneralsTypeService.insert(configGeneralsTypeVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody ConfigGeneralsTypeVo configGeneralsTypeVo){
		if(configGeneralsTypeVo.getId() == null){
			return HttpResult.error();
		}
		int i = configGeneralsTypeService.update(configGeneralsTypeVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody ConfigGeneralsTypeVo configGeneralsTypeVo){
		if(configGeneralsTypeVo.getId() == null){
			return HttpResult.error();
		}
		int i = configGeneralsTypeService.delete(configGeneralsTypeVo);
		return HttpResult.judge(i);
	}

}
