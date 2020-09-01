package com.star.aspect;

import com.star.Log;
import com.star.proxy.User;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class UserServiceImpl implements UserService, ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }


    @Log
    @Override
    public void register(User user) {
        System.out.println("执行register");
//        throw new RuntimeException("测试异常");
        UserService userService = (UserService) context.getBean("userService");
        userService.login("joy", "123");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("login");
        return true;
    }


}
