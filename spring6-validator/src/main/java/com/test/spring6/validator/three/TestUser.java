package com.test.spring6.validator.three;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestUser {

    @Test
    public void testUser() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyService myService = context.getBean(MyService.class);

        User user = new User();
        user.setName("Nike");
        user.setPhone("13112341234");
        myService.testMethod(user);
    }
}
