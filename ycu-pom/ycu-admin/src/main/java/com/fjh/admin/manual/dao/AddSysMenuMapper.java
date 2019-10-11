package com.fjh.admin.manual.dao;


import com.fjh.admin.auto.model.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddSysMenuMapper {

    List<SysMenu> findPage();

    List<SysMenu> findPageByName(@Param(value = "name") String name);

    List<SysMenu> findAll();

    List<SysMenu> findByUserName(@Param(value = "userName") String userName);

    List<SysMenu> findRoleMenus(@Param(value = "roleId") Long roleId);
}