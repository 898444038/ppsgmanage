package com.ming.ppsg.ppsg.entity.config;


import com.ming.ppsg.tool.generate.annotation.Comment;
import com.ming.ppsg.tool.generate.annotation.Description;
import com.ming.ppsg.tool.generate.annotation.GenerateMybatis;
import com.ming.ppsg.tool.generate.annotation.PrimaryKey;

@Description(author = "wang",desc = "武将星级配置")
@GenerateMybatis(isEffect = false,tableName = "p_config_star", classMapping = "/ppsg/config/star",baseUrl="config")
public class ConfigStar {

    @PrimaryKey
    private Long id;

    @Comment("1,2,3,4,5")
    private String code;

    @Comment("白,黑,银,金,钻")
    private String name;

    public ConfigStar(){}

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
