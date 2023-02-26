package com.atguigu.spring6.autowired.controller;

import com.atguigu.spring6.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

//    // 第一种 属性注入
//    @Autowired  // 根据类型找到对应的对象，完成注入
//    private UserService userService;

//    // 第二种set注入
//    private UserService userService;
//
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

//    // 第三种 构造方法注入
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

//    // 第四种 行参上 注入
//    private UserService userService;
//
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }
    // 第五种 只有一个构造器 无注解
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        System.out.println("controller ... ");
        userService.add();
    }
}
