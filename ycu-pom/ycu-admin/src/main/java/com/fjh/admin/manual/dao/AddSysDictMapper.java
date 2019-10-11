package com.fjh.admin.manual.dao;


import com.fjh.admin.auto.model.SysDict;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddSysDictMapper {


    List<SysDict> findPage();

    List<SysDict> findPageByLabel(@Param(value = "label") String label);

    List<SysDict> findByLable(@Param(value = "label") String label);
}