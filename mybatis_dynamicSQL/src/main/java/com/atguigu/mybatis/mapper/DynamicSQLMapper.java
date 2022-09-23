package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSQLMapper {
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 批量添加员工信息
     * @param emps
     */
    void insertEmps(@Param("emps") List<Emp> emps);

    void deleteEmps(@Param("empIds") int[] empIds);
}
