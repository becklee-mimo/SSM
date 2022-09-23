package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userToMap = mapper.getUserToMap(1);
        System.out.println("user = " + userToMap);
    }

    /**
     *{1={password=abc12345, gender=男, id=1, age=23, email=123@qq.com, username=root1},
     *  2={password=123456, gender=男, id=2, age=23, email=123@qq.com, username=admin},
     *  3={password=123456, gender=男, id=3, age=23, email=123@qq.com, username=admin},
     *  5={password=root2, gender=男, id=5, age=22, email=123@qq.com, username=root2}}
     */
//    @Test
//    public void testGetAllUserToMap() {
//        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
//        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//        Map<String, Object> map = mapper.getAllUserToMap();
//        System.out.println(map);
//    }
    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<Map<String, Object>> allUserToMap = mapper.getAllUserToMap();
        System.out.println(allUserToMap);

    }
}
