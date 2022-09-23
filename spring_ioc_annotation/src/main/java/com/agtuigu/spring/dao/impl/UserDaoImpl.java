package com.agtuigu.spring.dao.impl;

import com.agtuigu.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void saveUser() {
        System.out.println("用户保存");
    }
}
