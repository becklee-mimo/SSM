package com.atguigu.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 生产代理对象的工厂类：生产目标类对应的代理类
 * target:被代理类
 * 当通过代理类.某个方法时，会自动调用InvocationHandler被重写得invoke方法
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            /**
             * 当我们通过代理类对象调用某方法时，会自动调用如下方法invoke()
             * proxy：代理对象
             * method：代理对象需要实现的方法，即其中需要重写的方法
             * args：method所对应方法的参数
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("日志： 方法：" + method.getName() + "参数：i:" + args[0] + "参数：j：" + args[1]);
                Object result = method.invoke(target, args);
                System.out.println("日志： 方法：" + method.getName() + "结果：" + result);
                return result;
            }
        };
        /**
         * newProxyInstance()：创建一个代理实例
         * 其中有三个参数：
         * 1、classLoader：加载动态生成的代理类的类加载器(应用类加载器)
         * 2、interfaces：目标对象实现的所有接口的class对象所组成的数组
         * 3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法
         */
        return Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
    }
}
