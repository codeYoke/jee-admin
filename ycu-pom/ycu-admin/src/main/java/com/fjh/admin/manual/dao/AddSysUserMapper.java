package com.fjh.admin.manual.dao;

import com.fjh.admin.auto.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddSysUserMapper {

    List<SysUser> findPage();

    SysUser findByName(@Param(value = "name") String name);

    List<SysUser> findPageByName(@Param(value = "name") String name);

    List<SysUser> findPageByNameAndEmail(@Param(value = "name") String name, @Param(value = "email") String email);

}