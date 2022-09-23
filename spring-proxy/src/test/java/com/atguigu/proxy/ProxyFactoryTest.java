package com.atguigu.proxy;

import com.atguigu.spring.proxy.Calculator;
import com.atguigu.spring.proxy.CalculatorImpl;
import com.atguigu.spring.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyFactoryTest {
    @Test
    public void testProxyFactory() {
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        //因为我们不知道代理类的类型，所以向上转型为其接口
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.div(2, 1);

    }
}
