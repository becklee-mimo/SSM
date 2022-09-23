package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.UserMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.lang.model.SourceVersion;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MybatisTest {
    @Test
    public void testInsert() throws IOException {
        //获取核心配置文件的输入流(apache.ibatis.io.Resources;)
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //sql的会话对象sqlSession是mybatis提供操作数据库的对象
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取UserMapper的代理实现类
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //调用map中的方法
        int result = mapper.insertUser();
        System.out.println("result = " + result);
        //提交事物和关闭资源
        sqlSession.close();

    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println("user = " + user);
        sqlSession.close();
    }
    @Test
    public void testGetAllUser(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
        sqlSession.close();
    }
    @Test
    public void testLeetCode(){
        List<Integer> paths = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < paths.size() - 1; i++) {
            sb.append(paths.get(i)).append("->");
        }
    }
}
