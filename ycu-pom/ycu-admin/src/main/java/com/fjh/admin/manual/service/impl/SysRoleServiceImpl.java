package com.fjh.admin.manual.service.impl;

import com.fjh.admin.auto.dao.SysMenuMapper;
import com.fjh.admin.auto.dao.SysRoleMapper;
import com.fjh.admin.auto.dao.SysRoleMenuMapper;
import com.fjh.admin.auto.model.SysMenu;
import com.fjh.admin.auto.model.SysRole;
import com.fjh.admin.auto.model.SysRoleMenu;
import com.fjh.admin.constant.SysConstants;

import com.fjh.admin.manual.dao.AddSysMenuMapper;
import com.fjh.admin.manual.dao.AddSysRoleMapper;
import com.fjh.admin.manual.dao.AddSysRoleMenuMapper;
import com.fjh.admin.manual.service.SysRoleService;
import com.fjh.core.page.MybatisPageHelper;
import com.fjh.core.page.PageRequest;
import com.fjh.core.page.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private AddSysRoleMapper addSysRoleMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    @Autowired
    private AddSysRoleMenuMapper addSysRoleMenuMapper;

    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Autowired
    private AddSysMenuMapper addSysMenuMapper;

    @Override
    public int save(SysRole record) {
        if (record.getId() == null || record.getId() == 0) {
            return sysRoleMapper.insertSelective(record);
        }
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int delete(SysRole record) {
        return sysRoleMapper.deleteByPrimaryKey(record.getId());
    }

    @Override
    public int delete(List<SysRole> records) {
        for (SysRole record : records) {
            delete(record);
        }
        return 1;
    }

    @Override
    public SysRole findById(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult findPage(PageRequest pageRequest) {
        Object label = pageRequest.getParam("name");
        if (label != null) {
            return MybatisPageHelper.findPage(pageRequest, addSysRoleMapper, "findPageByName", label);
        }
        return MybatisPageHelper.findPage(pageRequest, addSysRoleMapper);
    }

    @Override
    public List<SysRole> findAll() {
        return addSysRoleMapper.findAll();
    }

    public SysRoleMapper getSysRoleMapper() {
        return sysRoleMapper;
    }

    public void setSysRoleMapper(SysRoleMapper sysRoleMapper) {
        this.sysRoleMapper = sysRoleMapper;
    }

    @Override
    public List<SysMenu> findRoleMenus(Long roleId) {
        SysRole sysRole = sysRoleMapper.selectByPrimaryKey(roleId);
        if (SysConstants.ADMIN.equalsIgnoreCase(sysRole.getName())) {
            // 如果是超级管理员，返回全部
            return addSysMenuMapper.findAll();
        }
        return addSysMenuMapper.findRoleMenus(roleId);
    }

    @Transactional
    @Override
    public int saveRoleMenus(List<SysRoleMenu> records) {
        if (records == null || records.isEmpty()) {
            return 1;
        }
        Long roleId = records.get(0).getRoleId();
        addSysRoleMenuMapper.deleteByRoleId(roleId);
        for (SysRoleMenu record : records) {
            sysRoleMenuMapper.insertSelective(record);
        }
        return 1;
    }

    @Override
    public List<SysRole> findByName(String name) {
        return addSysRoleMapper.findByName(name);
    }

}
