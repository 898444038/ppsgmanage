package com.ming.ppsg.ppsg.entity.config;


import com.ming.ppsg.tool.generate.annotation.Comment;
import com.ming.ppsg.tool.generate.annotation.Description;
import com.ming.ppsg.tool.generate.annotation.GenerateMybatis;
import com.ming.ppsg.tool.generate.annotation.PrimaryKey;

@Description(author = "wang",desc = "数据字典配置")
@GenerateMybatis(isEffect = false,tableName = "p_config_dict", classMapping = "/ppsg/config/dict",baseUrl="config")
public class ConfigDict {

    @PrimaryKey
    private Long id;

    @Comment("编号")
    private String code;

    @Comment("名称")
    private String name;

    public ConfigDict(){}

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
