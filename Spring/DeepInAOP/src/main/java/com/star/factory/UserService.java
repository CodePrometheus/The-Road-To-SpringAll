package com.star.factory;

import com.star.proxy.User;

public interface UserService {

    void login(String name, String password);

    void register(User user);
}
