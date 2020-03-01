package com.ming.ppsg.ppsg.service.impl.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.ppsg.entity.config.ConfigGeneralsType;
import com.ming.ppsg.ppsg.vo.config.ConfigGeneralsTypeVo;
import com.ming.ppsg.ppsg.service.config.ConfigGeneralsTypeService;
import com.ming.ppsg.ppsg.mapper.config.ConfigGeneralsTypeMapper;
import org.springframework.stereotype.Service;

/**
 * 武将类型配置
 * @author: wang
 * @date: 2020-02-29 16:34:16
 */
@Service
public class ConfigGeneralsTypeServiceImpl implements ConfigGeneralsTypeService {

	@Resource
	private ConfigGeneralsTypeMapper configGeneralsTypeMapper;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@Override
	public List<ConfigGeneralsType> select(ConfigGeneralsTypeVo configGeneralsTypeVo){
		return configGeneralsTypeMapper.select(configGeneralsTypeVo);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@Override
	public int insert(ConfigGeneralsTypeVo configGeneralsTypeVo){
		return configGeneralsTypeMapper.insert(configGeneralsTypeVo);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@Override
	public int update(ConfigGeneralsTypeVo configGeneralsTypeVo){
		return configGeneralsTypeMapper.update(configGeneralsTypeVo);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	@Override
	public int delete(ConfigGeneralsTypeVo configGeneralsTypeVo){
		return configGeneralsTypeMapper.delete(configGeneralsTypeVo);
	}

}
