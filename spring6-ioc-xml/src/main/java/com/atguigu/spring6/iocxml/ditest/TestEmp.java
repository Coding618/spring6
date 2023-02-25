package com.atguigu.spring6.iocxml.ditest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEmp {

    @Test
    public void TestEmpdi() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-diarray.xml");
        Emp emp = context.getBean("emp", Emp.class);
        emp.work();
    }
}
