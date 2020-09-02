package com.star.factory;

import com.star.proxy.User;

public class UserServiceImpl implements UserService {
    @Override
    public void login(String name, String password) {
        System.out.println("UserService.login");
    }

    @Override
    public void register(User user) {
        System.out.println("UserService.register");
    }
}
