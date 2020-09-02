package com.star.action;

import com.opensymphony.xwork2.Action;
import com.star.entity.User;
import com.star.service.UserService;

public class RegAction implements Action {
    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private UserService userService;

    private User user;

    @Override
    public String execute() throws Exception {
        userService.register(user);
        return Action.SUCCESS;
    }
}
