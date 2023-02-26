package com.atguigu.spring6.resource;

import com.atguigu.spring6.config.SpringConfig;
import com.atguigu.spring6.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserControllerAnnotation {

    @Test
    public void testUserController() {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        UserController controller = context.getBean(UserController.class);
        controller.add();
    }
}
