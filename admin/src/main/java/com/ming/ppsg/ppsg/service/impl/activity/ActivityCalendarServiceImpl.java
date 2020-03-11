package com.ming.ppsg.ppsg.service.impl.activity;

import com.ming.ppsg.ppsg.entity.activity.ActivityCalendar;
import com.ming.ppsg.ppsg.mapper.activity.ActivityCalendarMapper;
import com.ming.ppsg.ppsg.service.activity.ActivityCalendarService;
import com.ming.ppsg.ppsg.vo.activity.ActivityCalendarVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 活动日历
 * @author: wang
 * @date: 2020-03-07 16:20:44
 */
@Service
public class ActivityCalendarServiceImpl implements ActivityCalendarService {

	@Resource
	private ActivityCalendarMapper activityCalendarMapper;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	public List<ActivityCalendar> select(ActivityCalendarVo activityCalendarVo){
		return activityCalendarMapper.select(activityCalendarVo);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	public int insert(ActivityCalendarVo activityCalendarVo){
		return activityCalendarMapper.insert(activityCalendarVo);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	public int update(ActivityCalendarVo activityCalendarVo){
		return activityCalendarMapper.update(activityCalendarVo);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	@Override
	public int delete(ActivityCalendarVo activityCalendarVo){
		return activityCalendarMapper.delete(activityCalendarVo);
	}

	@Override
	public ActivityCalendar selectByDate(ActivityCalendarVo activityCalendarVo) {
		return activityCalendarMapper.selectByDate(activityCalendarVo);
	}

}
