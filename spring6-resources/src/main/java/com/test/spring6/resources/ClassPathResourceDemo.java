package com.test.spring6.resources;

import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;

public class ClassPathResourceDemo {

//    @Test
//    public void testClassPathResource() {
//        loadClassPathResource("file:test.md");
//    }
    public static void main(String[] args) {
        loadClassPathResource("test.md");
    }

    public static void loadClassPathResource(String path) {
        // 创建对象
        ClassPathResource resource = new ClassPathResource(path);

        // 获取文件名
        System.out.println(resource.getFilename());

        // 获取文件描述
        System.out.println(resource.getDescription());
        try {
            // 获取文件内容
            InputStream in = resource.getInputStream();
            byte[] bytes = new byte[1024];
            while(in.read(bytes) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
