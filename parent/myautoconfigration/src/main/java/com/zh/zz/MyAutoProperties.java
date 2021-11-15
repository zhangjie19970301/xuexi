package com.zh.zz;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "zh.zz")
public class MyAutoProperties {

private String name="ZhangJie";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
