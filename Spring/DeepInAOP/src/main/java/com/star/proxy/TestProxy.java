package com.star.proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestProxy {

    @Test
    public void test1() {
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.login("joy", "123");
        userServiceProxy.register(new User());
        System.out.println("===========");

        OrderServiceProxy orderServiceProxy = new OrderServiceProxy();
        orderServiceProxy.showOrder();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("proxy/spring.xml");
        UserService userService = (UserService) context.getBean("userService");
//        userService.login("joy", "123");
        userService.register(new User());
    }

    @Test
    public void test3(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("proxy/spring.xml");
        OrderService orderService = (OrderService) context.getBean("orderService");
        orderService.showOrder();
    }



}
