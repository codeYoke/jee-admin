package com.kp.myboot.admin.service;

import java.util.List;

import com.kp.myboot.admin.model.SysConfig;
import com.kp.myboot.core.service.CurdService;

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
