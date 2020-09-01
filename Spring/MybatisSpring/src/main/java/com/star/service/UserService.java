package com.star.service;

import com.star.entity.User;

public interface UserService {

    void register(User user);

    void login(String name, String password);
}
