package com.star.service;

import com.star.dao.UserDAO;
import com.star.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class UserServiceImpl implements UserService{
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void register(User user) {
        userDAO.save(user);
    }
}
