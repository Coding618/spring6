package com.atguigu.spring6.iocxml.auto.service;

import com.atguigu.spring6.iocxml.auto.dao.UserDao;
import com.atguigu.spring6.iocxml.auto.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService 实现了.... ");
//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
        userDao.addUserDao();
    }
}
