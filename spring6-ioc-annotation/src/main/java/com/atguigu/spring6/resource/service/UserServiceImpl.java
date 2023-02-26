package com.atguigu.spring6.resource.service;


import com.atguigu.spring6.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "myUserService")
public class UserServiceImpl implements UserService {

    //第一种 根据name名注入
    @Resource(name = "myUserDao")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service...... resource");
        userDao.add();
    }
}
