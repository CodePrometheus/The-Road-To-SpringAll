package com.star.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Aspect//用在类上，代表这是一个类
@Configuration
@Order(1)//数字越小优先执行加在类上
public class MyAspect {


    //    环绕通知 当目标方法执行时，会先进入环绕通知，然后在环境通知放行之后进入目标方法执行，完成之后回到环绕通知
    @Around("within(com.star.service.*ServiceImpl)")
    public Object around0(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知0");
        System.out.println(proceedingJoinPoint.getSignature().getName());
        System.out.println(proceedingJoinPoint.getTarget());
        System.out.println(proceedingJoinPoint.getArgs());
        System.out.println(proceedingJoinPoint.getThis());
        Object proceed = proceedingJoinPoint.proceed();//放行执行业务方法
        System.out.println("业务方法执行之后的业务处理0");
        return proceed;
    }


    //    前置通知，在目标方法执行之前执行操作
    @Before("within(com.star.service.*ServiceImpl)")//类级别的
//    拿到切点连接点的相关消息
    public void before(JoinPoint joinPoint) {
        System.out.println("目标方法的名称" + joinPoint.getSignature().getName());
        System.out.println("目标方法的参数" + joinPoint.getArgs());
        System.out.println("目标对象" + joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getStaticPart());
        System.out.println("前置通知");
    }

    //    后置方法
    @After("within(com.star.service.*ServiceImpl)")
    public void after(JoinPoint joinPoint) {
        System.out.println("目标方法的名称" + joinPoint.getSignature().getName());
        System.out.println("目标方法的参数" + joinPoint.getArgs());
        System.out.println("目标对象" + joinPoint.getTarget());
        System.out.println(joinPoint.getThis());
        System.out.println(joinPoint.getStaticPart());
        System.out.println("后置通知");
    }


}
