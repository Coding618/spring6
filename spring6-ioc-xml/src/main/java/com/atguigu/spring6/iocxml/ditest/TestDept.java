package com.atguigu.spring6.iocxml.ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDept {

    @Test
    public void TestDeptdi(){
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-dilist.xml");
        Dept dept = context.getBean("dept", Dept.class);
        dept.info();
    }

}
