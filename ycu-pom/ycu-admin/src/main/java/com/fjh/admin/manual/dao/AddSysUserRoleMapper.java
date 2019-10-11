package com.fjh.admin.manual.dao;

import com.fjh.admin.auto.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: AddSysUserRoleMapper
 * Description:
 *
 * @author 冯佳豪
 */
public interface AddSysUserRoleMapper {

    List<SysUserRole> findUserRoles(@Param(value = "userId") Long userId);

    int deleteByUserId(@Param(value = "userId") Long userId);
}
