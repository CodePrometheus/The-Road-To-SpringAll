package com.star;

import com.star.dao.UserDAO;
import com.star.entity.User;
import com.star.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatis {

    @Test
    public void test1(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserDAO userDAO = (UserDAO) context.getBean("userDAO");
        User user = new User();
        user.setName("周杰伦");
        user.setAge("30");
        user.setId(7);
        userDAO.save(user);

    }

//    测试事务处理
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-tx.xml");
        UserService userService = (UserService) context.getBean("userService");

        User user = new User();
        user.setName("刘德华");
        user.setAge("45");
        user.setId(9);
        userService.register(user);
    }
}
