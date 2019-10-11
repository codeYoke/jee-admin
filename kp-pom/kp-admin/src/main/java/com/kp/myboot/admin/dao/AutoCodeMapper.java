package com.kp.myboot.admin.dao;

import com.kp.myboot.admin.model.AutoCode;

import java.util.List;

//@Mapper
public interface AutoCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AutoCode record);

    int insertSelective(AutoCode record);

    AutoCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AutoCode record);

    int updateByPrimaryKey(AutoCode record);

    List<AutoCode> findAll();
}