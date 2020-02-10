package com.ming.ppsg.admin.service;

import java.util.List;

import com.ming.ppsg.admin.entity.SysDept;
import com.ming.ppsg.core.crud.CurdService;

/**
 * 机构管理
 * @author Louis
 * @date Oct 29, 2018
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
