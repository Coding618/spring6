package com.atguigu.spring6.iocxml.ditest;

import java.util.List;

public class Dept {
    private String dname;

    private List<Emp> empList;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public List<Emp> getEmpList() {
        return empList;
    }

    public void setEmpList(List<Emp> empList) {
        this.empList = empList;
    }

    public void info() {
        System.out.println("部门的名称： " + dname);
        for (Emp emp : empList) {
            System.out.println(emp.getEname());
        }
    }
}
