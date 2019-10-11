package com.fjh.admin.manual.dao;

import com.fjh.admin.auto.model.SysConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddSysConfigMapper {
    List<SysConfig> findPage();

    List<SysConfig> findPageByLabel(@Param(value = "label") String label);

    List<SysConfig> findByLable(@Param(value = "label") String label);
}