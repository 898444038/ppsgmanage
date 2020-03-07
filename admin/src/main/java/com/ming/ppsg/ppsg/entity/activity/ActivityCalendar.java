package com.ming.ppsg.ppsg.entity.activity;

import com.ming.ppsg.tool.generate.annotation.*;

import java.util.Date;

@Description(author = "wang",desc = "活动日历")
@GenerateMybatis(isEffect = false,tableName = "p_activity_calendar", classMapping = "/ppsg/activity/calendar",baseUrl="activity")
public class ActivityCalendar {

    @PrimaryKey
    private Long id;
    @Comment("开始时间")
    private Date startDate;
    @Comment("结束时间")
    private Date endDate;
    @Comment("活动名称")
    private String name;
    @Text
    @Comment("活动内容")
    private String content;
    @Comment("是否过期")
    private Boolean expire;

    public ActivityCalendar() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getExpire() {
        return expire;
    }

    public void setExpire(Boolean expire) {
        this.expire = expire;
    }
}
