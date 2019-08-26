package com.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

public class LogAspect {


    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log:" + joinPoint.getSignature().getName());

        Object object = joinPoint.proceed();
        System.out.println("end log:" + joinPoint.getSignature().getName());

        return object;
    }
}