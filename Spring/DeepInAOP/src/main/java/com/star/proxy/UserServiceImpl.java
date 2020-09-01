package com.star.proxy;

import com.star.Log;

public class UserServiceImpl implements UserService {

    @Log
    @Override
    public void register(User user) {
        System.out.println("执行register");
//        throw new RuntimeException("测试异常");
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("login");
        return true;
    }
}
