package com.kp.myboot.admin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    /**
     * hello*/
    public String hello(String name, Model model, ModelAndView modelAndView) {
        model.addAttribute("abc", "model");
        modelAndView.addObject("mv", "mv");
        modelAndView.setViewName("xx");
        return "name:" + name;
    }
}
