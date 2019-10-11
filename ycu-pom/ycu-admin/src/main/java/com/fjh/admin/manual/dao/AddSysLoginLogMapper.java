package com.fjh.admin.manual.dao;


import com.fjh.admin.auto.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddSysLoginLogMapper {


    List<SysLog> findPage();

    List<SysLog> findPageByUserName(@Param(value = "userName") String userName);

    List<SysLog> findPageByStatus(@Param(value = "status") String status);
}