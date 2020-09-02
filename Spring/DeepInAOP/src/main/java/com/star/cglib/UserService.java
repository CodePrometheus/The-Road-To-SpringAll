package com.star.cglib;

import com.star.proxy.User;

public class UserService {

    public void login(String name,String password){
        System.out.println("UserService.login");
    }

    public void register(User user){
        System.out.println("UserService.register");
    }

}
