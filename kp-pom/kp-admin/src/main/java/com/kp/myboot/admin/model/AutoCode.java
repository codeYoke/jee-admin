package com.kp.myboot.admin.model;

import java.util.Date;

public class AutoCode {
    private Integer id;

    private String name;

    private Float price;

    private Date birth;

    private String userName;

    public AutoCode(Integer id, String name, Float price, Date birth, String userName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.birth = birth;
        this.userName = userName;
    }

    public AutoCode() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }
}