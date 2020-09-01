package com.star.jdk;

import com.star.proxy.User;
import com.star.proxy.UserService;
import com.star.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestJDKProxy {

    public static void main(String[] args) {
//        创建原始对象
        UserServiceImpl userService = new UserServiceImpl();

        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy ==== log");
//                原始方法运行
                Object ret = method.invoke(userService, args);
                return ret;
            }
        };

//        基于JDK创建动态代理  借用类加载器
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(TestJDKProxy.class.getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.login("joy", "123");
        userServiceProxy.register(new User());
    }
}
