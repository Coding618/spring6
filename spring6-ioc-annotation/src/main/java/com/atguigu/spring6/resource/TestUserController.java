package com.atguigu.spring6.resource;

import com.atguigu.spring6.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserController {

    @Test
    public void testUserController() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
