package com.zh.controller;

import com.zh.bean.Users;
import com.zh.service.UserService;
import com.zh.zz.GetPropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;
    @Autowired
    GetPropertiesService service;

    @GetMapping("/test/{id}")
    public Users getUser(@PathVariable("id") Integer id){
        Users user=userService.getUser(id);
        return user;
    }
    @GetMapping("/user/{id}")
    public String getUser1(@PathVariable("id") Integer id){

        return service.myAuto();
    }
}
