package com.fjh.admin.manual.service;


import com.fjh.admin.auto.model.SysConfig;
import com.fjh.core.service.CurdService;

import java.util.List;

/**
 * 系统配置管理
 */
public interface SysConfigService extends CurdService<SysConfig> {

    /**
     * 根据名称查询
     *
     * @param lable
     * @return
     */
    List<SysConfig> findByLable(String lable);
}
