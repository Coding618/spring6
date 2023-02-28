package com.test.bean;

import com.test.annotation.Bean;
import com.test.annotation.Di;
import com.test.service.Impl.UserServiceImpl;
import com.test.service.UserService;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationApplicationContext implements ApplicationContext{

    // 创建map集合，存放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();
    private static String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 创建有参数构造器，传递包路径，设置包扫描规则
    // 当前包 及其子类，哪个类有@Bean注解，把这个类通过反射实例化
    public AnnotationApplicationContext(String basePackage){
        // com.test

        try {
            // 1. 把 . 替换成 \
            String packagePath = basePackage.replaceAll("\\.", "\\\\");

            // 2. 获取包绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");
                // 获取包前面的路径部分，采用字符截取
                rootPath = filePath.substring(0, filePath.length() - packagePath.length());

                // 包扫描
                loadBean(new File(filePath));

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 属性注入
        loadDi();


    }



    // 包扫描过程，实例化
    private void loadBean(File file) throws  Exception {

        // 1. 判断当前是否是文件夹
        if(file.isDirectory()){
            // 2. 获取文件夹里面的内容
            File[] childrenFiles = file.listFiles();
            // 3. 判断文件夹为空，则直接返回。
            if(childrenFiles.length ==0 || childrenFiles == null){
                return;
            }

            // 4. 如果文件夹不为空，则遍历文件夹里的所有内容
            for (File child : childrenFiles) {
                // 4.1 遍历得到File对象，继续判断，如果还是文件夹，继续递归
                if (child.isDirectory()){
                    loadBean(child);
                }else{  // 4.2 遍历得到File对象 不是文件夹，是文件，

                    // 4.3 得到包的路径 + 类名称部分  --> 字符串的提取过程
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    // 4.4 判断当前文件的类型是否 .class, 判断字符串尾部
                    if (pathWithClass.endsWith(".class")){
                        // 4.5 如果是 .class类型，把路径中的 \ 替换成 .  把 .class 去掉
                        // 得到的格式是：com.test.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");

                        // 4.6 判断上面是否有注解 @Bean，如果有，使用反射，实例化过程
                        // 4.6.1 获取类的class
                        Class<?> clazz = Class.forName(allName);

                        // 4.6.2 判断是不是接口
                        if (!clazz.isInterface()){
                            // 4.6.3 判断上面是否有注解 @Bean
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if(annotation != null){
                                // 4.6.4 实例化
                                Object instance = clazz.getConstructor().newInstance();
                                // 4.7 把对象实例化之后，放到 map集合 beanFactory
                                //4.7.1 判断当前的类，如果有接口，则让class作为map的
                                if (clazz.getInterfaces().length>0){
                                    System.out.println("正在加载【" + clazz.getInterfaces()[0] + "】， 实例对象是：" +
                                            instance.getClass().getName());
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                }else {
                                    System.out.println("正在加载【" + clazz.getName() + "】， 实例对象是：" +
                                            instance.getClass().getName());
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }

                    }
                }

            }
        }




    }

    private void loadDi() {
        // 实例化 对象在 beanFactory 的 map 集合里面
        // 1. 遍历 beanFactory 的map集合。
        Set<Map.Entry<Class, Object>> entries = beanFactory.entrySet();
        // 2. 获取map集合中的每个对象（value），每个对象属性获取到。
        for (Map.Entry<Class, Object> entry : entries) {
            Object obj = entry.getValue();
            // 获取对象 Class
            Class<?> clazz = obj.getClass();
            // 获取每个对象的属性
            Field[] declaredFields = clazz.getDeclaredFields();

            // 3. 遍历得到每个对象属性 数组，得到每个属性
            for (Field field : declaredFields) {
                // 4. 判断属性上是否有 @Di 注解；
                // 获取属性
                Di annotation = field.getAnnotation(Di.class);
                if(annotation != null) {
                    // 5. 如果有 @Di注解，把对象进行设置（注入）
                    // 如果有私有属性，设置 可设置权限
                    field.setAccessible(true);
                    try {
                        System.out.println("------------正在给【" + obj.getClass().getName() +"】属性【" + field.getName() + "】注入值【" +
                                beanFactory.get(field.getType()).getClass() + "】");
                        field.set(obj, beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
