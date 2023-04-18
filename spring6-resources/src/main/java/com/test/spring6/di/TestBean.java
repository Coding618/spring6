package com.test.spring6.di;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBean {

    @Test
    public void testBena() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-di.xml");
        ResourceBean resourceBean = context.getBean("resourceBean", ResourceBean.class);
        resourceBean.paras();
    }

}
