package com.ming.ppsg.ppsg.service.impl.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.ppsg.entity.config.ConfigDict;
import com.ming.ppsg.ppsg.vo.config.ConfigDictVo;
import com.ming.ppsg.ppsg.service.config.ConfigDictService;
import com.ming.ppsg.ppsg.mapper.config.ConfigDictMapper;
import org.springframework.stereotype.Service;

/**
 * 数据字典配置
 * @author: wang
 * @date: 2020-02-29 16:42:32
 */
@Service
public class ConfigDictServiceImpl implements ConfigDictService {

	@Resource
	private ConfigDictMapper configDictMapper;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@Override
	public List<ConfigDict> select(ConfigDictVo configDictVo){
		return configDictMapper.select(configDictVo);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@Override
	public int insert(ConfigDictVo configDictVo){
		return configDictMapper.insert(configDictVo);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@Override
	public int update(ConfigDictVo configDictVo){
		return configDictMapper.update(configDictVo);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	@Override
	public int delete(ConfigDictVo configDictVo){
		return configDictMapper.delete(configDictVo);
	}

}
