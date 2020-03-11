package com.ming.ppsg.client.ppsg.service.activity;

import java.util.Map;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.cloud.openfeign.FeignClient;
import com.ming.ppsg.client.ppsg.service.impl.activity.ActivityCalendarServiceImpl;

@FeignClient(name = "ppsg-server",fallback = ActivityCalendarServiceImpl.class)
public interface ActivityCalendarService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/ppsg/activity/calendar/select")
	public HttpResult select(@RequestBody Map<String,Object> map);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/ppsg/activity/calendar/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/ppsg/activity/calendar/update")
	public HttpResult update(@RequestBody Map<String,Object> map);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/ppsg/activity/calendar/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map);

}

