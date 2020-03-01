package com.ming.ppsg.ppsg.service.config;

import com.ming.ppsg.ppsg.entity.config.ConfigCountry;
import com.ming.ppsg.ppsg.vo.config.ConfigCountryVo;

import java.util.List;

public interface ConfigCountryService {
    /**
     * 查询
     * @author: wang
     * @date: 2020-02-28 18:58:03
     */
    List<ConfigCountry> select(ConfigCountryVo configCountryVo);

    /**
     * 新增
     * @author: wang
     * @date: 2020-02-28 18:58:03
     */
    int insert(ConfigCountryVo configCountryVo);

    /**
     * 根据id更新
     * @author: wang
     * @date: 2020-02-28 18:58:03
     */
    int update(ConfigCountryVo configCountryVo);

    /**
     * 根据id删除
     * @author: wang
     * @date: 2020-02-28 18:58:03
     */
    int delete(ConfigCountryVo configCountryVo);
}
