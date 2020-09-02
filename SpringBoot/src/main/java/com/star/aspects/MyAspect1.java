package com.star.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect
@Configuration
@Order(0)
public class MyAspect1 {
    @Around("within(com.star.service.*ServiceImpl)")
    public Object around1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知1");
        System.out.println(proceedingJoinPoint.getSignature().getName());
        System.out.println(proceedingJoinPoint.getTarget());
        System.out.println(proceedingJoinPoint.getArgs());
        System.out.println(proceedingJoinPoint.getThis());
        Object proceed = proceedingJoinPoint.proceed();//放行执行业务方法
        System.out.println("业务方法执行之后的业务处理1");
        return proceed;
    }

}
