package com.atguigu.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

@Aspect
@Component
public class LoggerAspect {

    @Pointcut("execution(* com.atguigu.spring.aop.annotation.CalculatorImpl.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {
        //获取连接点对应的签名信息
        Signature signature = joinPoint.getSignature();
        System.out.println(Modifier.toString(signature.getModifiers()));

        //获取连接点对应的方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect，方法：" + signature.getName() + " 参数：" + Arrays.toString(args));
    }

    @After("pointCut()")
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法：" + signature.getName() + " 执行完毕");
    }

    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法：" + signature.getName() + "结果：" + result);
    }

    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Throwable exception) {
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect，方法：" + signature.getName() + ",异常通知: " + exception);
    }

    @Around("pointCut()")
    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object result = null;
        try {
            System.out.println("环绕通知 -> 前置通知");
            //相当于目标方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知 -> 返回通知");

        } catch (Throwable throwable) {
            System.out.println("环绕通知 -> 异常通知");
            throwable.printStackTrace();
        } finally {
            System.out.println("环绕通知 -> 后置通知");
        }
        return result;
    }
}
