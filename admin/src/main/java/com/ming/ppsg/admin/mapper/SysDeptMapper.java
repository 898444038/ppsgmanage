package com.ming.ppsg.admin.mapper;

import com.ming.ppsg.admin.entity.SysDept;

import java.util.List;


public interface SysDeptMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    SysDept selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);
    
    List<SysDept> findPage();
    
    List<SysDept> findAll();
}