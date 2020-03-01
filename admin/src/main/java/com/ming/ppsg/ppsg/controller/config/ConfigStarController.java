package com.ming.ppsg.ppsg.controller.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.ppsg.entity.config.ConfigStar;
import com.ming.ppsg.ppsg.service.config.ConfigStarService;
import com.ming.ppsg.ppsg.vo.config.ConfigStarVo;

/**
 * 武将星级配置
 * @author: wang
 * @date: 2020-02-28 21:33:09
 */
@RestController
@RequestMapping("/ppsg/config/star")
public class ConfigStarController {

	@Resource
	private ConfigStarService configStarService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody ConfigStarVo configStarVo){
		List<ConfigStar> list = configStarService.select(configStarVo);
		return HttpResult.ok(list);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody ConfigStarVo configStarVo){
		int i = configStarService.insert(configStarVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody ConfigStarVo configStarVo){
		if(configStarVo.getId() == null){
			return HttpResult.error();
		}
		int i = configStarService.update(configStarVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody ConfigStarVo configStarVo){
		if(configStarVo.getId() == null){
			return HttpResult.error();
		}
		int i = configStarService.delete(configStarVo);
		return HttpResult.judge(i);
	}

}
