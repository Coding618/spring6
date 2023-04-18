package com.test.spring6.prefix;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

public class TestDemo {

    @Test
    public void testDemo1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean.xml");
        Resource resource = context.getResource("test.txt");
        System.out.println(resource.getDescription());
    }
    
    @Test
    public void testDemo2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean*.xml");
        User user = context.getBean(User.class);
        System.out.println(user);

    }
}
