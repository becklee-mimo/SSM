package com.atguigu.spring.test;

import com.atguigu.spring.aop.annotation.Calculator;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AOPTest {
    @Test
    public void testAOPByAnnotation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("aop-annotation.xml");
        //AOP底层使用得是动态代理，所以和动态代理一样，我们不知道代理类得类型，所以获取其接口
        Calculator calculator = ioc.getBean(Calculator.class);
        calculator.div(4, 2);
    }


}
