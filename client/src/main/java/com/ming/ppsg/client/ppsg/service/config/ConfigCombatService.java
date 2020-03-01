package com.ming.ppsg.client.ppsg.service.config;

import java.util.Map;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import com.ming.ppsg.client.ppsg.service.impl.config.ConfigCombatServiceImpl;

@FeignClient(name = "ppsg-server",fallback = ConfigCombatServiceImpl.class)
public interface ConfigCombatService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/ppsg/config/combat/select")
	public HttpResult select(@RequestBody Map<String,Object> map);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/ppsg/config/combat/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/ppsg/config/combat/update")
	public HttpResult update(@RequestBody Map<String,Object> map);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 15:54:11
	 */
	@PostMapping("/ppsg/config/combat/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map);

}

