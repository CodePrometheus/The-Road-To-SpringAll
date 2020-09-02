package com.star.cglib;

import com.star.proxy.User;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TestCglib {

    public static void main(String[] args) {
//        1.原始对象
        UserService userService = new UserService();

        Enhancer enhancer = new Enhancer();
//        2.类加载器
        enhancer.setClassLoader(TestCglib.class.getClassLoader());
//        3.父类
        enhancer.setSuperclass(userService.getClass());

        MethodInterceptor interceptor = new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("======= cglib  log ==========");
                Object invoke = method.invoke(userService, args);
                return invoke;
            }
        };

//        4.额外功能
        enhancer.setCallback(interceptor);

//        5.创建代理
        UserService userServiceProxy = (UserService) enhancer.create();
        userServiceProxy.login("joy", "123");
        userServiceProxy.register(new User());

    }
}
