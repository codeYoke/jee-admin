package com.fjh.admin.manual.dao;


import com.fjh.admin.auto.model.SysRoleMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddSysRoleMenuMapper {

    List<SysRoleMenu> findRoleMenus(@Param(value = "roleId") Long roleId);

    List<SysRoleMenu> findAll();

    int deleteByRoleId(@Param(value = "roleId") Long roleId);
}