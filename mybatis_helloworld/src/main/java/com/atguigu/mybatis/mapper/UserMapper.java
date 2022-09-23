package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户信息
     * @return
     */
    int insertUser();

    /**
     * 修改用户信息
     * @return
     */
    int updateUser();

    /**
     * 删除用户信息
     */
    void deleteUser();

    /**
     * 根据ID来查询用户信息
     * @return
     */
    User getUserById();

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getAllUser();
}