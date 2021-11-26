package com.zh.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Aspect
@Component
public class AOPThread {

    @Pointcut(value = "@annotation(com.zh.annotation.AopAnnotation)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        System.out.println("打印：" + sign.getDeclaringTypeName() + " 前置");
    }

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {

        Lock look=new ReentrantLock();

        try {
            look.lock();
            Object result = point.proceed();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            look.unlock();
        }
        return null;
    }
    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("调用aspect 方法结束");
    }



}
