package com.atguigu.proxy;

import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.CalculatorStaticProxy;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy(){
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(1, 2);

    }
}
