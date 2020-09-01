package com.star.dynamic;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Around implements MethodInterceptor {

//    额外功能书写在invoke中  Object原始方法的返回值
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object proceed = null;
        try {
            proceed = methodInvocation.proceed();
        } catch (Throwable throwable) {
            System.out.println("异常之后的额外处理");
            throwable.printStackTrace();
        }
        return proceed;
    }
}
