package com.kp.myboot.admin.service.impl;

import com.kp.myboot.admin.dao.AutoCodeMapper;
import com.kp.myboot.admin.model.AutoCode;
import com.kp.myboot.admin.service.AutoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AutoCodeServiceImpl implements AutoCodeService {
    @Autowired
    private AutoCodeMapper mapper;

    @Transactional(readOnly = true)
    public List<AutoCode> findAll() {
        return mapper.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void save() {
        //mapper1.save();
        //mapper2.save()
    }
}
