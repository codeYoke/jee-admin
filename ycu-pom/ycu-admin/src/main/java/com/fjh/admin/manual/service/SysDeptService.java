package com.fjh.admin.manual.service;

import com.fjh.admin.auto.model.SysDept;
import com.fjh.core.service.CurdService;


import java.util.List;

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
