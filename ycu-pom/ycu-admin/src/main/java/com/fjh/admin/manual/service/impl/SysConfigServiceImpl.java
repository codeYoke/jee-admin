package com.fjh.admin.manual.service.impl;

import com.fjh.admin.auto.dao.SysConfigMapper;
import com.fjh.admin.auto.model.SysConfig;
import com.fjh.admin.manual.dao.AddSysConfigMapper;
import com.fjh.admin.manual.service.SysConfigService;
import com.fjh.core.page.MybatisPageHelper;
import com.fjh.core.page.PageRequest;
import com.fjh.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysConfigServiceImpl implements SysConfigService {

    @Autowired
    private SysConfigMapper sysConfigMapper;
    @Autowired
    private AddSysConfigMapper addSysConfigMapper;

    @Override
    public int save(SysConfig record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysConfigMapper.insertSelective(record);
        }
        return sysConfigMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysConfig record) {
        return sysConfigMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysConfig> records) {
        for (SysConfig record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysConfig findById(Long id) {
        return sysConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, addSysConfigMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, addSysConfigMapper);
    }

    @Override
    public List<SysConfig> findByLable(String lable) {
        return addSysConfigMapper.findByLable(lable);
    }

}
