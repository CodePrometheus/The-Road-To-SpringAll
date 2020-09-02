package com.star.proxy;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userService = new UserServiceImpl();

    @Override
    public void register(User user) {
        System.out.println("代理实现register");
        userService.register(user);
    }

    @Override
    public boolean login(String name, String password) {
        System.out.println("代理实现login");
        return userService.login(name, password);
    }
}
