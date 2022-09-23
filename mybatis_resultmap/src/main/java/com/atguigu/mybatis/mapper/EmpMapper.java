package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpMapper {

    Emp getUserByEmpId(@Param("empId") Integer empId);

    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 通过分步查询员工及他所在的部门的第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 通过分步查询部门以及部门的员工信息的第二步
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);

}
