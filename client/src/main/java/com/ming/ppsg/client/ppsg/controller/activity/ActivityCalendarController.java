package com.ming.ppsg.client.ppsg.controller.activity;

import java.util.Map;
import javax.annotation.Resource;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ming.ppsg.client.ppsg.service.activity.ActivityCalendarService;

/**
 * 活动日历
 * @author: wang
 * @date: 2020-03-07 16:20:44
 */
@RestController
@RequestMapping("/ppsg/activity/calendar")
public class ActivityCalendarController {

	@Resource
	private ActivityCalendarService activityCalendarService;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/select")
	public HttpResult select(@RequestBody Map<String,Object> map){
		return activityCalendarService.select(map);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody Map<String,Object> map){
		return activityCalendarService.insert(map);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody Map<String,Object> map){
		return activityCalendarService.update(map);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody Map<String,Object> map){
		return activityCalendarService.delete(map);
	}

}
