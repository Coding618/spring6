package com.test.service.Impl;

import com.test.annotation.Bean;
import com.test.annotation.Di;
import com.test.dao.UserDao;
import com.test.service.UserService;

@Bean
public class UserServiceImpl implements UserService {

    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service  ......   ");
        userDao.add();
    }
}
