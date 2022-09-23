package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class TestScopeController {

    @RequestMapping("/test/mav")
    public ModelAndView testMAV() {
        ModelAndView mav = new ModelAndView();
        //共享数据
        mav.addObject("testRequestScope", "hello,ModeAndView");
        mav.setViewName("success");
        return mav;
    }
    @RequestMapping("/test/model")
    public String testModel(Model model) {
        model.addAttribute("testRequestScope", "hello,Model");
        return "success";
    }

    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap) {
        modelMap.addAttribute("testRequestScope", "hello,ModelMap");
        return "success";
    }
    @RequestMapping("/test/map")
    public String testMap(Map<String,Object> map) {
        map.put("testRequestScope", "hello,Map");
        return "success";
    }

    @RequestMapping("/test/session")
    public String testSession(HttpSession session) {
        session.setAttribute("testSessionScope","hello, session");
        return "success";
    }

    @RequestMapping("/test/application")
    public String testApplication(HttpSession session) {
        ServletContext application = session.getServletContext();
        application.setAttribute("testApplicationScope", "hello, application");
        return "success";
    }
}
