package com.star.dynamic;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Before1 implements MethodBeforeAdvice {

    @Override
    //Method额外功能所增加给的那个原始方法
    //Object[]额外功能所增加给的那个原始方法的参数
    //Object代表的是原始对象
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("method before1 advice");
    }



}
