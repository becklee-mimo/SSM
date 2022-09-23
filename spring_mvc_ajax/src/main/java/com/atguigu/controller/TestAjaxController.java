package com.atguigu.controller;

import com.atguigu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class TestAjaxController {

    @RequestMapping( "/test/ajax")
    public void testAjax(Integer id, HttpServletResponse response, @RequestBody String json) throws IOException {
        System.out.println("id = " + id);
        System.out.println("json = " + json);
        response.getWriter().write("hello,ajax");
    }

    @RequestMapping("/test/requestBody/json")
    public void testRequestBody(@RequestBody User user, HttpServletResponse response) throws IOException {
        System.out.println("user = " + user);
        response.getWriter().write("hello,requestBody");
    }


    @RequestMapping("/test/ResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/test/ResponseBody/json")
    @ResponseBody
    public User testResponseBodyJson(HttpSession session) throws IOException {
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext.getRealPath("/"));
        User user = new User(1001,"admin","12345",24,"男");
        return user;
    }
}
