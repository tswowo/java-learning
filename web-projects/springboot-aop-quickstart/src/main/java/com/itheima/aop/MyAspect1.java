package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
//@Component
//@Aspect
public class MyAspect1 {

//    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.(list|delete)(..))")
//    public void before() {
//        System.out.println("Before");
//    }

    @Before("@annotation(com.itheima.anno.LogOperation)")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before");

        //对象
        System.out.println("对象:" + joinPoint.getTarget());
        //类
        System.out.println("类" + joinPoint.getTarget().getClass());
        //方法
        System.out.println("方法" + joinPoint.getSignature().getName());
        //参数
        System.out.println("参数" + joinPoint.getArgs());

        System.out.print("参数");
        for (Object arg : joinPoint.getArgs())
            System.out.println("," + arg);
    }
}
