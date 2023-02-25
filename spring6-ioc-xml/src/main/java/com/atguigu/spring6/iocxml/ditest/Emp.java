package com.atguigu.spring6.iocxml.ditest;

import java.util.Arrays;

public class Emp {

    // 对象类型的属性：  员工所在部门
    private Dept dept;
    // 员工名称
    private String ename;

    // 员工年龄
    private int age;

    // 爱好
    private String[] loves;

    public String[] getLoves() {
        return loves;
    }

    public void setLoves(String[] loves) {
        this.loves = loves;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                ", ename='" + ename + '\'' +
                ", age=" + age +
                ", loves=" + Arrays.toString(loves) +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void work() {
        System.out.println(ename + " emp work ... " + age);
        dept.info();
        System.out.println(Arrays.toString(loves));
    }
}
