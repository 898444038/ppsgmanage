package com.ming.ppsg.ppsg.controller.activity;

import com.ming.ppsg.ppsg.entity.activity.ActivityCalendar;
import com.ming.ppsg.ppsg.service.activity.ActivityCalendarService;
import com.ming.ppsg.ppsg.vo.activity.ActivityCalendarVo;
import com.ming.ppsg.tool.date.DatesUtil;
import com.ming.ppsg.tool.http.HttpResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

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
	public HttpResult select(@RequestBody ActivityCalendarVo activityCalendarVo){
		activityCalendarVo.setStartDate(DatesUtil.getBeginWeek(activityCalendarVo.getWeek()));
		activityCalendarVo.setEndDate(DatesUtil.getEndWeek(activityCalendarVo.getWeek()));
		List<ActivityCalendar> list = activityCalendarService.select(activityCalendarVo);
		return HttpResult.ok(list);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/insert")
	public HttpResult insert(@RequestBody ActivityCalendarVo activityCalendarVo){
		int i = activityCalendarService.insert(activityCalendarVo);
		return HttpResult.judge(i);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/update")
	public HttpResult update(@RequestBody ActivityCalendarVo activityCalendarVo){
		activityCalendarVo.setStartDate(DatesUtil.getBeginWeek(activityCalendarVo.getWeek()));
		activityCalendarVo.setEndDate(DatesUtil.getEndWeek(activityCalendarVo.getWeek()));
		ActivityCalendar activityCalendar = activityCalendarService.selectByDate(activityCalendarVo);
		if(activityCalendar == null){
			SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy");
			String year = sdf2.format(activityCalendarVo.getStartDate());
			String startDate = sdf.format(activityCalendarVo.getStartDate());
			String endDate = sdf.format(activityCalendarVo.getEndDate());
			activityCalendarVo.setName("活动"+year+"("+startDate+"~"+endDate+")");
			int i = activityCalendarService.insert(activityCalendarVo);
			return HttpResult.judge(i);
		}else{
			activityCalendarVo.setId(activityCalendar.getId());
			activityCalendarVo.setName(activityCalendar.getName());
			int i = activityCalendarService.update(activityCalendarVo);
			return HttpResult.judge(i);
		}
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@PostMapping("/delete")
	public HttpResult delete(@RequestBody ActivityCalendarVo activityCalendarVo){
		if(activityCalendarVo.getId() == null){
			return HttpResult.error();
		}
		int i = activityCalendarService.delete(activityCalendarVo);
		return HttpResult.judge(i);
	}

}
