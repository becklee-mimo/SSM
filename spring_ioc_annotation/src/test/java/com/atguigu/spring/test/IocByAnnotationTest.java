package com.atguigu.spring.test;

import com.agtuigu.spring.controller.UserController;
import com.agtuigu.spring.dao.UserDao;
import com.agtuigu.spring.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocByAnnotationTest {
    @Test
    public void test(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-ioc-annotation.xml");
        UserController userController = ioc.getBean(UserController.class);
       userController.saveUser();

    }
}
