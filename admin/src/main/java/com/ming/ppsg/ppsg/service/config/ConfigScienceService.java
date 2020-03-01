package com.ming.ppsg.ppsg.service.config;

import java.util.List;
import com.ming.ppsg.ppsg.entity.config.ConfigScience;
import com.ming.ppsg.ppsg.vo.config.ConfigScienceVo;

/**
 * 科技配置
 * @author: wang
 * @date: 2020-02-29 17:06:03
 */
public interface ConfigScienceService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	List<ConfigScience> select(ConfigScienceVo configScienceVo);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	int insert(ConfigScienceVo configScienceVo);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	int update(ConfigScienceVo configScienceVo);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 17:06:03
	 */
	int delete(ConfigScienceVo configScienceVo);

}
