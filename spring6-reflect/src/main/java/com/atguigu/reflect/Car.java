package com.atguigu.reflect;

public class Car {

    //属性
    private String name;

    private int age;

    private String color;

    // 无参构造器
    public Car() {
    }

    // 形参构造器

    public Car(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }


    //get set 方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
