package com.ming.ppsg.ppsg.controller.xzl.entity;

public class CountryArms {

    private Integer count;

    private String name;

    public CountryArms() {}

    public CountryArms(Integer count, String name) {
        this.count = count;
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
