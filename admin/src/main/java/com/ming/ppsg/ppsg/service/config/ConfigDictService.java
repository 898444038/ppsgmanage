package com.ming.ppsg.ppsg.service.config;

import java.util.List;
import com.ming.ppsg.ppsg.entity.config.ConfigDict;
import com.ming.ppsg.ppsg.vo.config.ConfigDictVo;

/**
 * 数据字典配置
 * @author: wang
 * @date: 2020-02-29 16:42:32
 */
public interface ConfigDictService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	List<ConfigDict> select(ConfigDictVo configDictVo);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	int insert(ConfigDictVo configDictVo);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	int update(ConfigDictVo configDictVo);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:42:32
	 */
	int delete(ConfigDictVo configDictVo);

}
