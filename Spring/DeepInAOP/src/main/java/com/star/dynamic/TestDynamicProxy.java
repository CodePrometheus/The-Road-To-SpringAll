package com.star.dynamic;

import com.star.proxy.User;
import com.star.proxy.UserService;
import com.star.proxy.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestDynamicProxy {

    public static void main(String[] args) {

        UserServiceImpl userService = new UserServiceImpl();//目标类
        System.out.println("原始对象" + userService.getClass());

//        当前线程中拿到类加载器
//        ClassLoader类加载器
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

//        Class[]目标对象的接口的类型的数组
        Class[] classes = {UserService.class};

//       参数3 InvocationHandle接口类型  invoke方法 额外功能

//        返回值即为创建好的动态代理的对象
        UserService userServiceDynamicProxy = (UserService) Proxy.newProxyInstance(classLoader, classes, new InvocationHandler() {
            @Override
            //通过动态代理对象调用代理中方法会优先执行此invoke方法
            //参数1 当前创建好的代理对象  参数2 当前代理对象执行的方法对象  参数3 当前代理对象执行方法的参数
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("当前执行的方法：" + method.getName());
                System.out.println("当前执行方法的参数：" + args[0]);
//                在这里调用目标类中的方法  通过反射
                try {
                    System.out.println("开启事务");
                    Object invoke = method.invoke(new UserServiceImpl(), args);
                    System.out.println("提交事务");
                    return invoke;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("回滚事务");
                }
                return null;
            }
        });

        //class com.sun.proxy.$Proxy0
        System.out.println(userServiceDynamicProxy.getClass());

        //通过动态代理对象调用代理中方法
        userServiceDynamicProxy.register(new User());

    }
}
