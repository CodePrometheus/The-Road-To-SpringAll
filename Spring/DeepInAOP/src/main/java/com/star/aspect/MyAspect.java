package com.star.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("execution(* UserServiceImpl.*(..))")
    public void myPointcut() {
    }

    @Around(value = "myPointcut()")
    //    around相当于invoke
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("=======");
        Object ret = joinPoint.proceed();
        return ret;
    }

    @Around(value = "myPointcut()")
    //    around相当于invoke
    public Object around1(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("====around1===");
        Object ret = joinPoint.proceed();
        return ret;
    }


}
