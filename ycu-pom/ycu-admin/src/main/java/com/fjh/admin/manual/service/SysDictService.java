package com.fjh.admin.manual.service;



import com.fjh.admin.auto.model.SysDict;
import com.fjh.core.service.CurdService;

import java.util.List;

/**
 * 字典管理
 */
public interface SysDictService extends CurdService<SysDict> {

    /**
     * 根据标签名称查询
     *
     * @param lable
     * @return
     */
    List<SysDict> findByLable(String lable);
}
