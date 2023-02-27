package com.atguigu.reflect;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    @Test
    public void test02() throws Exception {
        Class clazz = Car.class;
        // getConstructors() 获取所有public的构造方法
//        Constructor[] constructors = clazz.getConstructors();
//        for (Constructor c : constructors) {
//            System.out.println("方法名称：" + c.getName() + ", 参数个数: " + c.getParameterCount());
//        }
        // getDeclaredConstructors() 获取所有构造器(private、public)
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor c : constructors) {
            System.out.println("方法名称: " + c.getName() + ", 参数个数：" + c.getParameterCount());
        }

        // 指定有参数构造器创建对象
        // 1. 构造public
//        Constructor c1 = clazz.getConstructor(String.class, int.class, String.class);
//        Car car1 = (Car)c1.newInstance("宝马", 5, "白色");
//        System.out.println(car1);
        // 2. 构造private
        Constructor c2 = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        c2.setAccessible(true);
        Car car2 = (Car) c2.newInstance("特斯拉", 1, "黑色");
        System.out.println(car2);
    }

    //3. 获取属性
    @Test
    public void test03() throws  Exception {
        Class clazz = Car.class;
        Car car = (Car)clazz.getDeclaredConstructor().newInstance();
        // 获取所有public属性
//        Field[] fields = clazz.getFields();
        // getDeclaredFields()表示，获取这个类自身声明的属性，其中就不包括从父亲继承的属性。可以调用private属性
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println("属性名称：" + f.getName());
            if (f.getName().equals("name")) {
                f.setAccessible(true);
                f.set(car, "BYD");
                System.out.println(car);
            }
        }

    }

    //4. 获取方法
    @Test
    public void test04() throws Exception {
        Car car = new Car("蔚来", 1, "yellow");
        Class clazz = car.getClass();
        // 1. 获取public 方法
//        Method[] m1 = clazz.getMethods();
//        for (Method m : m1) {
//            System.out.println(m.getName());
//        }

        // 2. 获取这个类自身声明的方法，包括private
        Method[] m2 = clazz.getDeclaredMethods();
        for (Method m : m2) {
//            System.out.println(m.getName());
            if(m.getName().equals("run")){
                m.setAccessible(true);
                m.invoke(car);
            }
        }
    }

}
