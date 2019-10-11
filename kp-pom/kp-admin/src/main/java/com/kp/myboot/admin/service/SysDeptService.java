package com.kp.myboot.admin.service;

import java.util.List;

import com.kp.myboot.admin.model.SysDept;
import com.kp.myboot.core.service.CurdService;

/**
 * 机构管理
 */
public interface SysDeptService extends CurdService<SysDept> {

    /**
     * 查询机构树
     *
     * @return
     */
    List<SysDept> findTree();
}
