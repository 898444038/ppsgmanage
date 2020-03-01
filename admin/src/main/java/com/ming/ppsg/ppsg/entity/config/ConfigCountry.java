package com.ming.ppsg.ppsg.entity.config;


import com.ming.ppsg.tool.generate.annotation.Description;
import com.ming.ppsg.tool.generate.annotation.GenerateMybatis;
import com.ming.ppsg.tool.generate.annotation.PrimaryKey;

@Description(author = "wang",desc = "国家配置")
@GenerateMybatis(isEffect = false,tableName = "p_config_country", classMapping = "/ppsg/config/country",baseUrl="config")
public class ConfigCountry {

    @PrimaryKey
    private Long id;

    private String code;

    private String name;

    public ConfigCountry(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
