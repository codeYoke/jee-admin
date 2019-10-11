package com.kp.myboot.admin.service;

import com.kp.myboot.admin.model.AutoCode;

import java.util.List;

public interface AutoCodeService {

    public List<AutoCode> findAll();

    public void save();
}
