package com.kp.myboot.admin.service;

import java.util.List;

import com.kp.myboot.admin.model.SysDict;
import com.kp.myboot.core.service.CurdService;

/**
 * 字典管理
 */
public interface SysDictService extends CurdService<SysDict> {

    /**
     * 根据名称查询
     *
     * @param lable
     * @return
     */
    List<SysDict> findByLable(String lable);
}
