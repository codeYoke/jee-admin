package com.fjh.admin.manual.dao;


import com.fjh.admin.auto.model.SysLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface AddSysLogMapper {


    List<SysLog> findPage();

    List<SysLog> findPageByUserName(@Param(value = "userName") String userName);
}