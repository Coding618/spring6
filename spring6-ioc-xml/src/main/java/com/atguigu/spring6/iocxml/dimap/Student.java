package com.atguigu.spring6.iocxml.dimap;

import java.util.List;
import java.util.Map;

public class Student {
    private int sId;

    private String sName;

    private Map<String, Teacher> teacherMap;

    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public void run() {
        System.out.println("学生编号：" + sId + "，学生姓名：" + sName);
        System.out.println(teacherMap);
        System.out.println(lessonList);
    }


}
