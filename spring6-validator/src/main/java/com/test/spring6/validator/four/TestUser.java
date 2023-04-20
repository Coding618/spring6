package com.test.spring6.validator.four;

//import com.test.spring6.validator.four.MyService;
//
//import com.test.spring6.validator.four.ValidationConfig;
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
        user.setMessage("Hello_world");
        myService.testMethod(user);
    }
}
