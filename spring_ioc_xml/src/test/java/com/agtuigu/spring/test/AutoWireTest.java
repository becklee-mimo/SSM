package com.agtuigu.spring.test;

import com.atguigu.spring.Controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class AutoWireTest {
    @Test
    public void testAutoWire() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-autowire.xml");
        UserController userController = ioc.getBean(UserController.class);
        userController.saveUser();
    }

    @Test
    public void testArraysCopyOf() {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5};
        int[] newInts = Arrays.copyOfRange(arr, 0, 2);
        for (int i : newInts) {
            System.out.println(i);
        }
    }
}
