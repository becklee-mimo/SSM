package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SpecialSQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLTest {

    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> a = mapper.getUserByLike("a");
        System.out.println(a);

    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        mapper.deleteUser("5,6,7,8,9");
    }

    @Test
    public void testGetUseList() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> users = mapper.getUserList("t_user");
        System.out.println(users);

    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper mapper = sqlSession.getMapper(SpecialSQLMapper.class);
        User user = new User(null, "xiaoming", "123456", 24, "女", "321@qq.com");
        int primaryKey = mapper.insertUser(user);

        System.out.println(user);
    }
}
