package com.ming.ppsg.ppsg.entity.config;


import com.ming.ppsg.tool.generate.annotation.Comment;
import com.ming.ppsg.tool.generate.annotation.Description;
import com.ming.ppsg.tool.generate.annotation.GenerateMybatis;
import com.ming.ppsg.tool.generate.annotation.PrimaryKey;

@Description(author = "wang",desc = "武将类型配置")
@GenerateMybatis(isEffect = false,tableName = "p_config_generals_type", classMapping = "/ppsg/config/generals/type",baseUrl="config")
public class ConfigGeneralsType {

    @PrimaryKey
    private Long id;

    @Comment("")
    private String code;

    @Comment("名称")
    private String name;

    @Comment("武力每级成长")
    private Integer forceGrowth;

    @Comment("智力每级成长")
    private Integer intellectGrowth;

    @Comment("兵力每级成长")
    private Integer troopsGrowth;

    public ConfigGeneralsType(){}

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

    public Integer getForceGrowth() {
        return forceGrowth;
    }

    public void setForceGrowth(Integer forceGrowth) {
        this.forceGrowth = forceGrowth;
    }

    public Integer getIntellectGrowth() {
        return intellectGrowth;
    }

    public void setIntellectGrowth(Integer intellectGrowth) {
        this.intellectGrowth = intellectGrowth;
    }

    public Integer getTroopsGrowth() {
        return troopsGrowth;
    }

    public void setTroopsGrowth(Integer troopsGrowth) {
        this.troopsGrowth = troopsGrowth;
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
