package com.ming.ppsg.ppsg.service.impl.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.ppsg.entity.config.ConfigCombat;
import com.ming.ppsg.ppsg.vo.config.ConfigCombatVo;
import com.ming.ppsg.ppsg.service.config.ConfigCombatService;
import com.ming.ppsg.ppsg.mapper.config.ConfigCombatMapper;
import org.springframework.stereotype.Service;

/**
 * 战力配置
 * @author: wang
 * @date: 2020-02-29 14:43:00
 */
@Service
public class ConfigCombatServiceImpl implements ConfigCombatService {

	@Resource
	private ConfigCombatMapper configCombatMapper;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@Override
	public List<ConfigCombat> select(ConfigCombatVo configCombatVo){
		return configCombatMapper.select(configCombatVo);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@Override
	public int insert(ConfigCombatVo configCombatVo){
		return configCombatMapper.insert(configCombatVo);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@Override
	public int update(ConfigCombatVo configCombatVo){
		return configCombatMapper.update(configCombatVo);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	@Override
	public int delete(ConfigCombatVo configCombatVo){
		return configCombatMapper.delete(configCombatVo);
	}

}
