package com.atguigu.ssm.controller;

import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * 查询所有员工信息   /employee   get
 * 根据id查询所有员工信息   /employee/1   get
 * 跳转到台南佳页面   /too/add   get
 * 添加员工信息   /employee   post
 * 修改员工信息   /employee   put
 * 删除员工信息   /employee/1   delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public String getAllEmployees(Model model) {
        List<Employee> list =employeeService.getAllEmployees();

        //将员工信息共享到请求域
        model.addAttribute("list",list);
        return "employee_list";

    }
}
