package com.ming.ppsg.ppsg.mapper.config;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ming.ppsg.ppsg.entity.config.ConfigCombat;
import com.ming.ppsg.ppsg.vo.config.ConfigCombatVo;

/**
 * 战力配置
 * @author: wang
 * @date: 2020-02-29 14:43:00
 */
@Mapper
public interface ConfigCombatMapper {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	List<ConfigCombat> select(ConfigCombatVo configCombatVo);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	int insert(ConfigCombatVo configCombatVo);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	int update(ConfigCombatVo configCombatVo);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 14:43:00
	 */
	int delete(ConfigCombatVo configCombatVo);

}

