package com.ming.ppsg.client.ppsg.service.impl.activity;

import java.util.Map;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.stereotype.Component;
import com.ming.ppsg.client.ppsg.service.activity.ActivityCalendarService;

@Component
public class ActivityCalendarServiceImpl implements ActivityCalendarService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	@PostMapping("/ppsg/activity/calendar/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	@PostMapping("/ppsg/activity/calendar/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	@PostMapping("/ppsg/activity/calendar/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	@PostMapping("/ppsg/activity/calendar/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return HttpResult.error("sorry, this service call failed.");
	}

}

