package com.test.bean;

import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext implements ApplicationContext{

    // 创建map集合，存放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 创建有参数构造类，传递包路径，设置包扫描规则
    // 当前包 及其子类，哪个类有@Bean注解，把这个类通过反射实例化
    public AnnotationApplicationContext(String basePackage){

    }
}
