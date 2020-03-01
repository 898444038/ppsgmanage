package com.ming.ppsg.ppsg.entity.config;


import com.ming.ppsg.tool.generate.annotation.Comment;
import com.ming.ppsg.tool.generate.annotation.Description;
import com.ming.ppsg.tool.generate.annotation.GenerateMybatis;
import com.ming.ppsg.tool.generate.annotation.PrimaryKey;

@Description(author = "wang",desc = "科技配置")
@GenerateMybatis(isEffect = false,tableName = "p_config_science", classMapping = "/ppsg/config/science",baseUrl="config")
public class ConfigScience {

    @PrimaryKey
    private Long id;

    @Comment("级别")
    private Integer level;

    @Comment("编号")
    private String code;

    @Comment("名称")
    private String name;

    @Comment("武力加成百分比")
    private Double forceRate;

    @Comment("智力加成百分比")
    private Double intellectRate;

    @Comment("兵力加成百分比")
    private Double troopsRate;

    @Comment("自身兵种伤害加成")
    private Double selfHurt;

    @Comment("自身兵种伤害加成描述")
    private String selfHurtDesc;

    @Comment("针对兵种伤害加成")
    private Double restraintHurt;

    @Comment("针对兵种伤害加成描述")
    private String restraintHurtDesc;

    public ConfigScience(){}

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getForceRate() {
        return forceRate;
    }

    public void setForceRate(Double forceRate) {
        this.forceRate = forceRate;
    }

    public Double getIntellectRate() {
        return intellectRate;
    }

    public void setIntellectRate(Double intellectRate) {
        this.intellectRate = intellectRate;
    }

    public Double getTroopsRate() {
        return troopsRate;
    }

    public void setTroopsRate(Double troopsRate) {
        this.troopsRate = troopsRate;
    }

    public Double getSelfHurt() {
        return selfHurt;
    }

    public void setSelfHurt(Double selfHurt) {
        this.selfHurt = selfHurt;
    }

    public String getSelfHurtDesc() {
        return selfHurtDesc;
    }

    public void setSelfHurtDesc(String selfHurtDesc) {
        this.selfHurtDesc = selfHurtDesc+selfHurt;
    }

    public Double getRestraintHurt() {
        return restraintHurt;
    }

    public void setRestraintHurt(Double restraintHurt) {
        this.restraintHurt = restraintHurt;
    }

    public String getRestraintHurtDesc() {
        return restraintHurtDesc;
    }

    public void setRestraintHurtDesc(String restraintHurtDesc) {
        this.restraintHurtDesc = restraintHurtDesc+restraintHurt;
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
