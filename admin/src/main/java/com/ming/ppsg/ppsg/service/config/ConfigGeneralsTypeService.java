package com.ming.ppsg.ppsg.service.config;

import java.util.List;
import com.ming.ppsg.ppsg.entity.config.ConfigGeneralsType;
import com.ming.ppsg.ppsg.vo.config.ConfigGeneralsTypeVo;

/**
 * 武将类型配置
 * @author: wang
 * @date: 2020-02-29 16:34:16
 */
public interface ConfigGeneralsTypeService {

	/**
	 * 查询
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	List<ConfigGeneralsType> select(ConfigGeneralsTypeVo configGeneralsTypeVo);

	/**
	 * 新增
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	int insert(ConfigGeneralsTypeVo configGeneralsTypeVo);

	/**
	 * 根据id更新
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	int update(ConfigGeneralsTypeVo configGeneralsTypeVo);

	/**
	 * 根据id删除
	 * @author: wang
	 * @date: 2020-02-29 16:34:16
	 */
	int delete(ConfigGeneralsTypeVo configGeneralsTypeVo);

}
