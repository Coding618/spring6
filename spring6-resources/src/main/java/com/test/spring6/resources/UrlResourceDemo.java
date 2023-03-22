package com.test.spring6.resources;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.UrlResource;

import java.net.MalformedURLException;
import java.nio.file.Path;

public class UrlResourceDemo {

//    @Test
//    public static void testResource() {
//        // https前缀
////        loadResource("http://www.baidu.com");
//
//        // file前缀
//        loadResource("file:test.txt");
//    }
    public static void main(String[] args) {
        //1 访问网络资源
        loadResource("http://www.atguigu.com");

        //2 访问文件系统资源
        loadResource("file:test.txt");
    }
    public static void loadResource(String path) {

        try {
            // 创建Resource实现类的对象 UrlResource
            UrlResource url = new UrlResource(path);

            // 获取资源信息
            System.out.println("文件名：" + url.getFilename());
//            System.out.println(url.getFile());
            System.out.println(url.getDescription());
            System.out.println(url.getURI());
            //获取资源内容
            System.out.println(url.getInputStream().read());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
