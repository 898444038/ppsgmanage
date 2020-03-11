package com.ming.ppsg.ppsg.vo.activity;

import com.ming.ppsg.ppsg.entity.activity.ActivityCalendar;

public class ActivityCalendarVo extends ActivityCalendar {

    private Integer week;

    public ActivityCalendarVo() {}

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }
}
