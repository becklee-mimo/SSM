package com.agtuigu.mybatis.test;

import com.atguigu.mybatis.mapper.DynamicSQLMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicMapperTest {
    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp emp1 = new Emp(null, "小明1", 22, "男");
        Emp emp2 = new Emp(null, "小明2", 22, "男");
        Emp emp3 = new Emp(null, "小明3", 22, "男");

        int[] ids= new int[]{5,6,7,8,9,10};
        mapper.deleteEmps(ids);


    }
}
