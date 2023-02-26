package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

public class TestCar {
    //1. 获取Class对象多种方式
    @Test
    public void test01() throws Exception {
        //1. 类名
        Class clazz1 = Car.class;

        //2. 对象.getClass()
        Class clazz2 = new Car().getClass();

        //3. Class.forName("全路径")
        Class clazz3 = Class.forName("com.atguigu.reflect.Car");

        // 实例化
        Car car = (Car) clazz3.getDeclaredConstructor().newInstance();
        System.out.println(car);
    }

    //2. 获取构造方法

    //3. 获取属性

    //4. 获取方法

}
