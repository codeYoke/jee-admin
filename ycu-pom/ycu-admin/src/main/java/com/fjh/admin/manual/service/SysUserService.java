package com.fjh.admin.manual.service;

import com.fjh.admin.auto.model.SysUser;
import com.fjh.admin.auto.model.SysUserRole;
import com.fjh.core.page.PageRequest;
import com.fjh.core.service.CurdService;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * ClassName: SysUserService
 * Description:用户管理service类
 *
 * @author 冯佳豪
 */
public interface SysUserService extends CurdService<SysUser> {
    SysUser findByName(String username);

    /**
     * 查找用户的菜单权限标识集合
     *
     * @param userName
     * @return
     */
    Set<String> findPermissions(String userName);

    /**
     * 查找用户的角色集合
     *
     * @param userId
     * @return
     */
    List<SysUserRole> findUserRoles(Long userId);

    /**
     * 生成用户信息Excel文件
     *
     * @param pageRequest 要导出的分页查询参数
     * @return
     */
    File createUserExcelFile(PageRequest pageRequest);
}
