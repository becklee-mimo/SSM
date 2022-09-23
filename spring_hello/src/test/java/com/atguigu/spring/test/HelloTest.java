package com.atguigu.spring.test;

import com.agtuigu.spring.pojo.HelloWord;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloTest {
    @Test
    public void testHello(){
        //获取IOC容器
        ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //获取IOC容器的bean对象
        HelloWord helloword = (HelloWord) ioc.getBean("helloword");
        helloword.sayHello();

    }
}
