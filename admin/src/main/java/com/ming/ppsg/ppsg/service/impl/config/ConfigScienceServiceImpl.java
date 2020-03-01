package com.ming.ppsg.ppsg.service.impl.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.ppsg.entity.config.ConfigScience;
import com.ming.ppsg.ppsg.vo.config.ConfigScienceVo;
import com.ming.ppsg.ppsg.service.config.ConfigScienceService;
import com.ming.ppsg.ppsg.mapper.config.ConfigScienceMapper;
import org.springframework.stereotype.Service;

/**
 * 科技配置
 * @author: wang
 * @date: 2020-02-29 17:06:03
 */
@Service
public class ConfigScienceServiceImpl implements ConfigScienceService {

	@Resource
	private ConfigScienceMapper configScienceMapper;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	public List<ConfigScience> select(ConfigScienceVo configScienceVo){
		return configScienceMapper.select(configScienceVo);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	public int insert(ConfigScienceVo configScienceVo){
		return configScienceMapper.insert(configScienceVo);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	public int update(ConfigScienceVo configScienceVo){
		return configScienceMapper.update(configScienceVo);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	@Override
	public int delete(ConfigScienceVo configScienceVo){
		return configScienceMapper.delete(configScienceVo);
	}

}
