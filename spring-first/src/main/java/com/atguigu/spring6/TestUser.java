package com.atguigu.spring6;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUser {

    private Logger logger = LoggerFactory.getLogger(TestUser.class);

    @Test
    public void testUserObject() {
        // 加载spring配置文件，对象创建
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        // 获取创建的对象
        User user = (User)context.getBean("user");
        System.out.println("1:   " +user);

        // 使用创建对象调用方法进行测试
        System.out.print("2:   ");
        user.add();
        logger.info("##### 手动写入成功 ########");
    }

    @Test
    public void testUserObject1() throws Exception {
        // 获取类Class对象
        Class clazz = Class.forName("com.atguigu.spring6.User");
        // 调用方法创建对象
        User user = (User)clazz.getDeclaredConstructor().newInstance();
        System.out.println(user);



    }
}
