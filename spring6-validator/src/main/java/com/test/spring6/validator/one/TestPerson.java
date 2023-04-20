package com.test.spring6.validator.one;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

public class TestPerson {

    @Test
    public void testPerson() {
        // 创建person对象
        Person person = new Person();
        person.setName("Trump");
        person.setAge(20);

        // 创建person对象对应的databinder
        DataBinder binder = new DataBinder(person);

        // 设置校验器
        binder.setValidator(new PersonValidator());

        // 调用方法 执行校验
        binder.validate();

        // 输出校验结果
        BindingResult bindingResult = binder.getBindingResult();
        System.out.println(bindingResult);
    }
}
