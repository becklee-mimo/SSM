package com.atguigu.controller;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * 查询所有员工信息   /user   get
 * 跳转到添加页面   /user   get
 * 新增员工信息   /user   post
 * 跳转到修改页面   /user/1   get
 * 修改员工信息   /user  put
 * 删除员工信息   /user/1   delete
 *
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        System.out.println("employees = " + employees);
        model.addAttribute("employees", employees);

        return "employee_list";
    }

    @PostMapping("/employee")
    public String addUser(Employee employee) {
        employeeDao.save(employee);
        System.out.println("employee = " + employee);
        //重定向到列表功能 /employee
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee", employee);
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

}
