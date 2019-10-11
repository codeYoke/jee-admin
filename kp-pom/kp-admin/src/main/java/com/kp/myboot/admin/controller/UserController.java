package com.kp.myboot.admin.controller;

import com.kp.myboot.admin.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping(value = "/getuser")
    public User getUser(int id, String username, String password) {
        return new User(id, username, password);
    }
}
