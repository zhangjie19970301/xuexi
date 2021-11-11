package com.zh.controller;

import com.zh.bean.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User user=new User();
        user.setName("张三");
        user.setIphone("11111111");
        return user;
    }

}
