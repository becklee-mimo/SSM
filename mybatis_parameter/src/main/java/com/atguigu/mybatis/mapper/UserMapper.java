package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    User getUserByUserName(String username);

    /**
     * 验证登录
     * @param username
     * @param password
     * @return
     */
    User checkLogin(String username,String password);

    /**
     * 验证登录(使用自己构建的map)
     * @param map
     * @return
     */
    User checkLogin1(Map<String,Object> map);

    /**
     * 添加用户
     * @param user
     */
    void insertUser(User user);

    User checkLoginByParam(@Param("username") String username,@Param("password") String password);
}
