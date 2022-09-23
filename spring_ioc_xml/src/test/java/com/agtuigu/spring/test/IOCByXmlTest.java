package com.agtuigu.spring.test;

import com.atguigu.spring.pojo.Clazz;
import com.atguigu.spring.pojo.Person;
import com.atguigu.spring.pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IOCByXmlTest {
    @Test
    public void test() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取Bean 方式1:
        // Student studentOne = (Student) ioc.getBean("studentOne");
        //获取Bean
        Student student = ioc.getBean(Student.class);
        System.out.println(student);


    }

    @Test
    public void testDI() {
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ioc.getBean("studentNew", Student.class);
        System.out.println(student);
    }
}
