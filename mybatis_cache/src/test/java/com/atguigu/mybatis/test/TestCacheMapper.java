package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestCacheMapper {
    @Test
    public void testGetEmpById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpById(1);
        Emp emp2 = mapper.getEmpById(1);
        System.out.println("emp1 = " + emp1);
        System.out.println("emp2 = " + emp2);
        SqlSession sqlSession1= SqlSessionUtils.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp3 = mapper1.getEmpById(1);
        System.out.println("emp3 = " + emp3);
    }

    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpById(1);
        sqlSession1.close();

        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpById(1);
        System.out.println("emp1 = " + emp1);
        System.out.println("emp2 = " + emp2);
        sqlSession2.close();

    }
}
