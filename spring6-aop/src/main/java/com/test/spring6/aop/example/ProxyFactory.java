package com.test.spring6.aop.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        // newProxyInstance() 创建一个代理实例
        // 三个参数
        // 1、ClassLoader loader：加载动态生成代理类的类加载器
        // 2、Class<?>[] interfaces：目标对象实现的所有接口的class对象，所组成的数组（列表）
        // 3、InvocationHandler：设置代理对象，实现目标对象方法的过程，即代理类中，如何重写接口中的抽象方法
        ClassLoader loader = target.getClass().getClassLoader();
        Class<?>[] interfaces = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler(){
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /**
                 * proxy: 代理对象
                 * method：代理对象所需实现的方法，即需要重写的方法
                 * args：方法所需要的参数
                 */
                System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                Object result = null;
                result = method.invoke(target, args);
                System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                return result;
            }
        };

        return Proxy.newProxyInstance(loader, interfaces, invocationHandler);
    }
}
