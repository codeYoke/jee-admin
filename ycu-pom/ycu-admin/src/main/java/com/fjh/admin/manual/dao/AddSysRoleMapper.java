package com.fjh.admin.manual.dao;


import com.fjh.admin.auto.model.SysRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddSysRoleMapper {


    List<SysRole> findPage();

    List<SysRole> findAll();

    List<SysRole> findPageByName(@Param(value = "name") String name);

    List<SysRole> findByName(@Param(value = "name") String name);
}