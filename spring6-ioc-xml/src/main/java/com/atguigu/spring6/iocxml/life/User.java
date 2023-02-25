package com.atguigu.spring6.iocxml.life;

public class User {

    String name;

    public User() {
        System.out.println("1. bean对象创建，调用无参构造器~ ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("2. 给bean对象设置属性");
        this.name = name;
    }

    public void initMethod(){
        System.out.println("4. bean对象初始化方法~ ");
    }

    public void destroyMethod() {
        System.out.println("7. bean对象销毁方法~ ");
    }

}
