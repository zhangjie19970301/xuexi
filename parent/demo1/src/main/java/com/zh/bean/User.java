package com.zh.bean;

import java.io.Serializable;

public class User implements Serializable {
    private String name;
    private  String iphone;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIphone() {
        return iphone;
    }

    public void setIphone(String iphone) {
        this.iphone = iphone;
    }
}
