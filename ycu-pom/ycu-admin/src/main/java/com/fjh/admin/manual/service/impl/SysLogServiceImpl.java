package com.fjh.admin.manual.service.impl;


import com.fjh.admin.auto.dao.SysLogMapper;
import com.fjh.admin.auto.model.SysLog;
import com.fjh.admin.manual.dao.AddSysLogMapper;
import com.fjh.admin.manual.service.SysLogService;
import com.fjh.core.page.MybatisPageHelper;
import com.fjh.core.page.PageRequest;
import com.fjh.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper sysLogMapper;
    @Autowired
    private AddSysLogMapper addSysLogMapper;

    @Override
    public int save(SysLog record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysLogMapper.insertSelective(record);
        }
        return sysLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysLog record) {
        return sysLogMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysLog> records) {
        for (SysLog record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysLog findById(Long id) {
        return sysLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("userName");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, addSysLogMapper, "findPageByUserName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, addSysLogMapper);
    }

}
