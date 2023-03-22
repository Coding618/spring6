package com.test.spring6.resources;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

public class FileSystemResourceDemo {

    public static void main(String[] args) {
        // 相对路径
        loadResource("test.txt");
        // 绝对路径
//        loadResource("D:\\suying域名.md");
    }

    public static void loadResource(String path) {

        FileSystemResource resource = new FileSystemResource(path);

        // 获取文件名
        System.out.println("文件名：" + resource.getFilename());

        // 获取文件描述
        System.out.println("获取文件描述: " + resource.getDescription());


        try {
            // 获取文件内容
            InputStream in = resource.getInputStream();
            byte[] b = new byte[1024];
            while(in.read(b) != -1) {
                System.out.println(new String(b));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
