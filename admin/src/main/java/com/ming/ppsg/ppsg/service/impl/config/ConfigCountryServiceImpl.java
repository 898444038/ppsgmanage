package com.ming.ppsg.ppsg.service.impl.config;

import com.ming.ppsg.ppsg.entity.config.ConfigCountry;
import com.ming.ppsg.ppsg.mapper.config.ConfigCountryMapper;
import com.ming.ppsg.ppsg.service.config.ConfigCountryService;
import com.ming.ppsg.ppsg.vo.config.ConfigCountryVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ConfigCountryServiceImpl implements ConfigCountryService {

    @Resource
    private ConfigCountryMapper configCountryMapper;


    /**
     * 查询
     * @author: wang
     * @date: 2020-02-28 19:11:02
     */
    @Override
    public List<ConfigCountry> select(ConfigCountryVo configCountryVo){
        return configCountryMapper.select(configCountryVo);
    }

    /**
     * 新增
     * @author: wang
     * @date: 2020-02-28 19:11:02
     */
    @Override
    public int insert(ConfigCountryVo configCountryVo){
        return configCountryMapper.insert(configCountryVo);
    }

    /**
     * 根据id更新
     * @author: wang
     * @date: 2020-02-28 19:11:02
     */
    @Override
    public int update(ConfigCountryVo configCountryVo){
        return configCountryMapper.update(configCountryVo);
    }

    /**
     * 根据id删除
     * @author: wang
     * @date: 2020-02-28 19:11:02
     */
    @Override
    public int delete(ConfigCountryVo configCountryVo){
        return configCountryMapper.delete(configCountryVo);
    }
}
