package com.agtuigu.spring.controller;


import com.agtuigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService1")
    private UserService userService;
    public void saveUser(){
        userService.saveUser();
    }

}
