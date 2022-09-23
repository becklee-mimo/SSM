package com.agtuigu.spring.service.impl;

import com.agtuigu.spring.dao.UserDao;
import com.agtuigu.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    @Qualifier("userDao1")
    private UserDao userDao;

    @Override
    public void saveUser() {
        userDao.saveUser();
    }
}
