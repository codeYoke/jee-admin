package com.fjh.admin.manual.service.impl;


import com.fjh.admin.auto.dao.SysDictMapper;
import com.fjh.admin.auto.model.SysDict;
import com.fjh.admin.manual.dao.AddSysDictMapper;
import com.fjh.admin.manual.service.SysDictService;
import com.fjh.core.page.MybatisPageHelper;
import com.fjh.core.page.PageRequest;
import com.fjh.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysDictServiceImpl implements SysDictService {

    @Autowired
    private SysDictMapper sysDictMapper;
    @Autowired
    private AddSysDictMapper addSysDictMapper;

    @Override
    public int save(SysDict record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysDictMapper.insertSelective(record);
        }
        return sysDictMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysDict record) {
        return sysDictMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysDict> records) {
        for (SysDict record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysDict findById(Long id) {
        return sysDictMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("label");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, addSysDictMapper, "findPageByLabel", label);
        }
        return MybatisPageHelper.findPage(pageRequest, addSysDictMapper);
    }

    @Override
    public List<SysDict> findByLable(String lable) {
        return addSysDictMapper.findByLable(lable);
    }

}
