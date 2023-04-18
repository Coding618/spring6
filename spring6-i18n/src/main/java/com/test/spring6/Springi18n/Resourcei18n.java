package com.test.spring6.Springi18n;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.Locale;

public class Resourcei18n {

    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        Object[] objs = new Object[]{"test", new Date().toString()};
        String message1 = context.getMessage("www.bing.com", objs, Locale.CHINA);
        System.out.println(message1);

        Object[] objs2 = new Object[]{"test", new Date().toString()};
        String message2 = context.getMessage("www.bing.com", objs, Locale.ENGLISH);
        System.out.println(message2);
    }
}
