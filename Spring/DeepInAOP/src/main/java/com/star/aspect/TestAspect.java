package com.star.aspect;

import com.star.proxy.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAspect {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspect/spring.xml");
        UserService userService = (UserService) context.getBean("userService");
//        userService.login("joy", "123");
        userService.register(new User());
    }
}
