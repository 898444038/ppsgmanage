package com.ming.ppsg.ppsg.mapper.activity;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ming.ppsg.ppsg.entity.activity.ActivityCalendar;
import com.ming.ppsg.ppsg.vo.activity.ActivityCalendarVo;

/**
 * 活动日历
 * @author: wang
 * @date: 2020-03-07 16:20:44
 */
@Mapper
public interface ActivityCalendarMapper {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	List<ActivityCalendar> select(ActivityCalendarVo activityCalendarVo);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	int insert(ActivityCalendarVo activityCalendarVo);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	int update(ActivityCalendarVo activityCalendarVo);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-03-07 16:20:44
	 */
	int delete(ActivityCalendarVo activityCalendarVo);

    ActivityCalendar selectByDate(ActivityCalendarVo activityCalendarVo);
}

