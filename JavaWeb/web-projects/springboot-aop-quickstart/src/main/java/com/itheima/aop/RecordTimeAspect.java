package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//@Aspect
//@Component
@Slf4j
public class RecordTimeAspect {
    @Before("execution(* com.itheima.service.impl.*.*(..))")
    public void before() {
        System.out.println("Before");
    }

    @Around("execution(* com.itheima.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("Around Before");
        long begin = System.currentTimeMillis();

        Object result = pjp.proceed();

        long end = System.currentTimeMillis();
        log.info("方法{}执行耗时：{}ms", pjp.getSignature(), end - begin);
        System.out.println("Around After");

        return result;
    }

    @After("execution(* com.itheima.service.impl.*.*(..))")
    public void after() {
        System.out.println("After");
    }

    @AfterReturning("execution(* com.itheima.service.impl.*.*(..))")
    public void afterReturning() {
        System.out.println("AfterReturning");
    }

    @AfterThrowing("execution(* com.itheima.service.impl.*.*(..))")
    public void afterThrowing() {
        System.out.println("AfterThrowing");
    }
}
