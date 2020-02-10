package com.ming.ppsg.admin.service.impl;


import com.ming.ppsg.admin.entity.SysLog;
import com.ming.ppsg.admin.mapper.SysLogMapper;
import com.ming.ppsg.admin.service.SysLogService;
import com.ming.ppsg.core.page.ColumnFilter;
import com.ming.ppsg.core.page.MybatisPageHelper;
import com.ming.ppsg.core.page.PageRequest;
import com.ming.ppsg.core.page.PageResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysLogServiceImpl  implements SysLogService {

	@Resource
	private SysLogMapper sysLogMapper;

	@Override
	public int save(SysLog record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysLogMapper.insertSelective(record);
		}
		return sysLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int update(SysLog record) {
		return sysLogMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysLog record) {
		return sysLogMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysLog> records) {
		for(SysLog record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysLog findById(Long id) {
		return sysLogMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		ColumnFilter columnFilter = pageRequest.getColumnFilter("userName");
		if(columnFilter != null) {
			return MybatisPageHelper.findPage(pageRequest, sysLogMapper, "findPageByUserName", columnFilter.getValue());
		}
		return MybatisPageHelper.findPage(pageRequest, sysLogMapper);
	}
	
}
