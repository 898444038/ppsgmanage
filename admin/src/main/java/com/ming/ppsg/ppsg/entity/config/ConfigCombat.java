package com.ming.ppsg.ppsg.entity.config;


import com.ming.ppsg.tool.generate.annotation.Comment;
import com.ming.ppsg.tool.generate.annotation.Description;
import com.ming.ppsg.tool.generate.annotation.GenerateMybatis;
import com.ming.ppsg.tool.generate.annotation.PrimaryKey;

@Description(author = "wang",desc = "战力配置")
@GenerateMybatis(isEffect = false,tableName = "p_config_combat", classMapping = "/ppsg/config/combat",baseUrl="config")
public class ConfigCombat {

    @PrimaryKey
    private Long id;

    @Comment("")
    private String code;

    @Comment("名称")
    private String name;

    @Comment("战力")
    private Integer combat;

    public ConfigCombat(){}

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

    public Integer getCombat() {
        return combat;
    }

    public void setCombat(Integer combat) {
        this.combat = combat;
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
