package com.test.spring6.resourcesload;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

public class ResourceLoadDemo {

    @Test
    public void demo1() {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Resource resource = context.getResource("test.txt");
        System.out.println(resource.getFilename());

    }

    @Test
    public void demo2() {
        ApplicationContext context = new FileSystemXmlApplicationContext();
        Resource resource = context.getResource("test.txt");
        System.out.println(resource.getFilename());
    }
}
