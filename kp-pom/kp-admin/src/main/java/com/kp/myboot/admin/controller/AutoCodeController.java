package com.kp.myboot.admin.controller;

import com.kp.myboot.admin.service.AutoCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutoCodeController {
    @Autowired
    private AutoCodeService service;

    @RequestMapping("/findAll")
    public Object findAll() {
        return service.findAll();
    }
}
