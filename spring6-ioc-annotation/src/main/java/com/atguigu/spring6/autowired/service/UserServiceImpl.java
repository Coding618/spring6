package com.atguigu.spring6.autowired.service;


import com.atguigu.spring6.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
//
//    // 第一种 属性注入
//    @Autowired  // 根据类型找到对应的对象，完成注入
//    private UserDao userDao;

//    // 第二种 set方法注入
//    private UserDao  userDao;
//
//    @Autowired
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    // 第三种 构造方法 注入
//    private UserDao userDao;
//
//    @Autowired
//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

//    // 第四种 行参上 注入
//    private UserDao userDao;
//
//    public UserServiceImpl(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

    // 第六种 使用@Autowired 和 @Qualifier注解注入
    @Autowired
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service......");
        userDao.add();
    }
}
