package com.fjh.admin.manual.service.impl;


import com.fjh.admin.auto.dao.SysLoginLogMapper;
import com.fjh.admin.auto.model.SysLoginLog;
import com.fjh.admin.manual.dao.AddSysLoginLogMapper;
import com.fjh.admin.manual.service.SysLoginLogService;
import com.fjh.core.page.MybatisPageHelper;
import com.fjh.core.page.PageRequest;
import com.fjh.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLoginLogServiceImpl implements SysLoginLogService {

    @Autowired
    private SysLoginLogMapper sysLoginLogMapper;
    @Autowired
    private AddSysLoginLogMapper addSysLoginLogMapper;
    @Override
    public int save(SysLoginLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLoginLogMapper.insertSelective(record);
        }
        return sysLoginLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLoginLog record) {
        return sysLoginLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLoginLog> records) {
        for (SysLoginLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLoginLog findById(Long id) {
        return sysLoginLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object userName = pageRequest.getParam("userName");
        if (userName != null) {
            return MybatisPageHelper.findPage(pageRequest, addSysLoginLogMapper, "findPageByUserName", userName);
        }
        Object status = pageRequest.getParam("status");
        if (status != null) {
            return MybatisPageHelper.findPage(pageRequest, addSysLoginLogMapper, "findPageByStatus", status);
        }
        return MybatisPageHelper.findPage(pageRequest, addSysLoginLogMapper);
    }

}
