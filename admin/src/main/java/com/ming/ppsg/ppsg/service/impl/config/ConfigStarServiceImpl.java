package com.ming.ppsg.ppsg.service.impl.config;

import java.util.List;
import javax.annotation.Resource;
import com.ming.ppsg.ppsg.entity.config.ConfigStar;
import com.ming.ppsg.ppsg.vo.config.ConfigStarVo;
import com.ming.ppsg.ppsg.service.config.ConfigStarService;
import com.ming.ppsg.ppsg.mapper.config.ConfigStarMapper;
import org.springframework.stereotype.Service;

/**
 * 武将星级配置
 * @author: wang
 * @date: 2020-02-28 21:33:09
 */
@Service
public class ConfigStarServiceImpl implements ConfigStarService {

	@Resource
	private ConfigStarMapper configStarMapper;

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@Override
	public List<ConfigStar> select(ConfigStarVo configStarVo){
		return configStarMapper.select(configStarVo);
	}

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@Override
	public int insert(ConfigStarVo configStarVo){
		return configStarMapper.insert(configStarVo);
	}

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@Override
	public int update(ConfigStarVo configStarVo){
		return configStarMapper.update(configStarVo);
	}

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	@Override
	public int delete(ConfigStarVo configStarVo){
		return configStarMapper.delete(configStarVo);
	}

}
