package com.zhfk.me.controller;

import com.zhfk.me.entity.UserEntity;
import com.zhfk.me.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/all")
    public Iterable<UserEntity> getUser(){
        return userService.findAllUser();
    }

    @RequestMapping("/user/{id}")
    public UserEntity getUserById(@PathVariable(value = "id") int id){
        return userService.findUserById(id);
    }
}
