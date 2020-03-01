package com.ming.ppsg.ppsg.mapper.config;

import com.ming.ppsg.ppsg.entity.config.ConfigCountry;
import com.ming.ppsg.ppsg.vo.config.ConfigCountryVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ConfigCountryMapper {
    /**
     * 查询
     * @author: wang
     * @date: 2020-02-28 19:16:53
     */
    List<ConfigCountry> select(ConfigCountryVo configCountryVo);

    /**
     * 新增
     * @author: wang
     * @date: 2020-02-28 19:16:53
     */
    int insert(ConfigCountryVo configCountryVo);

    /**
     * 根据id更新
     * @author: wang
     * @date: 2020-02-28 19:16:53
     */
    int update(ConfigCountryVo configCountryVo);

    /**
     * 根据id删除
     * @author: wang
     * @date: 2020-02-28 19:16:53
     */
    int delete(ConfigCountryVo configCountryVo);
}