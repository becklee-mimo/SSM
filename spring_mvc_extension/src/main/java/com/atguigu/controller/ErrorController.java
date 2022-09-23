package com.atguigu.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    //@ExceptionHandler用于设置所标识方法处理的异常

    @ExceptionHandler(ArithmeticException.class)
    //ex表示当前请求处理中出现的异常对象
    public String testError(Model model,Exception ex){
        model.addAttribute("ex", ex);
        return "error";
    }
}
