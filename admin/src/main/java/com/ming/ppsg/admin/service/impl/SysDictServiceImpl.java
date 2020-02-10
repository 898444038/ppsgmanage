package com.ming.ppsg.admin.service.impl;


import com.ming.ppsg.admin.entity.SysDict;
import com.ming.ppsg.admin.mapper.SysDictMapper;
import com.ming.ppsg.admin.service.SysDictService;
import com.ming.ppsg.core.page.ColumnFilter;
import com.ming.ppsg.core.page.MybatisPageHelper;
import com.ming.ppsg.core.page.PageRequest;
import com.ming.ppsg.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysDictServiceImpl  implements SysDictService {

	@Resource
	private SysDictMapper sysDictMapper;

	@Override
	public int save(SysDict record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysDictMapper.insertSelective(record);
		}
		return sysDictMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(SysDict record) {
		return sysDictMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysDict record) {
		return sysDictMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDict> records) {
		for(SysDict record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysDict findById(Long id) {
		return sysDictMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		ColumnFilter columnFilter = pageRequest.getColumnFilter("label");
		if(columnFilter != null) {
			return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", columnFilter.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
	}

	@Override
	public List<SysDict> findByLable(String lable) {
		return sysDictMapper.findByLable(lable);
	}

}
