package com.test.spring6.aop.annoaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect // @Aspect这个类是一个切面类
@Component  // @Component 注解保证这个切面类能够放入IOC容器
public class LogAspect {

    // 前置通知
//    @Before(value = "execution(public int com.test.spring6.aop.annoaop.CalculatorImpl.*(..))")
    @Before("pointCut()") // 重用切入点表达式
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.out.println("Logger --> 前置通知，方法名：" + methodName + "，参数：" + args);
    }

    // 后置通知
//    @After(value = "execution(public int com.test.spring6.aop.annoaop.CalculatorImpl.*(..))")
    @After("pointCut()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--> 后置通知，方法名："+ methodName);
    }

    // 返回通知
//    @AfterReturning(value = "execution(public int com.test.spring6.aop.annoaop.CalculatorImpl.*(..))", returning = "result")
    @AfterReturning(value = "com.test.spring6.aop.annoaop.LogAspect.pointCut()",  returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result)  {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--> 返回通知，方法名："+ methodName + "，返回结果：" + result);
    }

    // 异常通知
//    @AfterThrowing(value = "execution(public int com.test.spring6.aop.annoaop.CalculatorImpl.*(..))", throwing = "ex")
    @AfterThrowing(value = "pointCut()", throwing = "ex")
    public void afterThrowingMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger--> 异常通知，方法名："+ methodName + "异常：" + ex);
    }

    // 环绕通知
//    @Around(value = "execution(public int com.test.spring6.aop.annoaop.CalculatorImpl.*(..))")
    @Around("pointCut()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        Object result = null;
        try {
            System.out.println("环绕通知--> 目标对象方法执行之前");
            // 目标对象(连接点)方法的执行
            result = joinPoint.proceed();
            System.out.println("环绕通知--> 目标对象方法执行之后");
        } catch (Throwable ex) {
             ex.printStackTrace();
            System.out.println("环绕通知--> 目标对象方法执行出现异常");
        } finally {
            System.out.println("环绕通知--> 目标对象方法执行完毕");
        }
        return result;
    }


    // 重用切入点表达式 声明
    @Pointcut("execution(* com.test.spring6.aop.annoaop.CalculatorImpl.*(..))")
    public void pointCut(){}

}
