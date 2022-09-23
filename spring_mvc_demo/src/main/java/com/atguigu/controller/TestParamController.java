package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TestParamController {

    @RequestMapping("/param/servletAPI")
    public String getParamByServletApi(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+username+",password:"+password);
        return "success";
    }

    @RequestMapping("/param")
    public String getParam(@RequestParam(value = "userName",
            required = false
            ) String username, String password){

        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "success";
    }


    @RequestMapping("/param/pojo")
    public String getParamByPojo(User user){
        System.out.println("user = " + user);
        return "success";
    }
}
