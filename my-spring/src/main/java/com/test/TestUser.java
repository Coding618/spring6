package com.test;

import com.test.bean.AnnotationApplicationContext;
import com.test.bean.ApplicationContext;
import com.test.service.UserService;
import org.junit.jupiter.api.Test;

public class TestUser {

    @Test
    public void testUser() {
        ApplicationContext context = new AnnotationApplicationContext("com.test");
        UserService userService = (UserService) context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}
