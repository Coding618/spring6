package com.test.spring6.validator.two;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestUser {

    @Test
    public void testValidatorOne() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation1 validation1 = context.getBean(MyValidation1.class);

        User user = new User();
        user.setName("Lee");
        user.setAge(144);
        boolean message = validation1.validatorByUserOne(user);
        System.out.println(message);
    }

    @Test
    public void testValidatorTwo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(ValidationConfig.class);
        MyValidation2 validation2 = context.getBean(MyValidation2.class);

        User user = new User();
        user.setName("Lee");
        user.setAge(1111);
        boolean message = validation2.validatorByUserTwo(user);
        System.out.println(message);
    }
}
