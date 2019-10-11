package com.fjh.admin.manual.dao;

;

import com.fjh.admin.auto.model.SysDept;

import java.util.List;

public interface AddSysDeptMapper {

    List<SysDept> findPage();

    List<SysDept> findAll();
}