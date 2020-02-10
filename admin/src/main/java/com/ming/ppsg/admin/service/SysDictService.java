package com.ming.ppsg.admin.service;

import java.util.List;

import com.ming.ppsg.admin.entity.SysDict;
import com.ming.ppsg.core.crud.CurdService;

/**
 * 字典管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
