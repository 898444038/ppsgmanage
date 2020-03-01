package com.ming.ppsg.ppsg.service.config;

import java.util.List;
import com.ming.ppsg.ppsg.entity.config.ConfigStar;
import com.ming.ppsg.ppsg.vo.config.ConfigStarVo;

/**
 * 武将星级配置
 * @author: wang
 * @date: 2020-02-28 21:33:09
 */
public interface ConfigStarService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	List<ConfigStar> select(ConfigStarVo configStarVo);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	int insert(ConfigStarVo configStarVo);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	int update(ConfigStarVo configStarVo);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-28 21:33:09
	 */
	int delete(ConfigStarVo configStarVo);

}
