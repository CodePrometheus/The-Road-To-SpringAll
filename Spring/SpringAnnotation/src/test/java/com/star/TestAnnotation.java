package com.star;

import com.star.bean.User;
import com.star.dao.Category;
import com.star.dao.UserService;
import com.star.dao.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAnnotation {

    @Test
    public void test1() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        User user = (User) context.getBean("u");
        System.out.println("userId = " + user.getId());
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Object customer = context.getBean("customer");
        Object customer1 = context.getBean("customer");
        System.out.println("customer = " + customer);
        System.out.println("customer1 = " + customer1);
    }

    @Test
    public void test3() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
//        Object account = context.getBean("account");
    }

    @Test
    public void test4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        UserService userServiceImpl = (UserService) context.getBean("userServiceImpl");

        userServiceImpl.register();
    }

    @Test
    public void test5() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Category category = (Category) context.getBean("category");
        System.out.println("category.getId() = " + category.getId());
        System.out.println("category.getName() = " + category.getName());
    }

    @Test
    public void test6() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName = " + beanDefinitionName);
        }
    }


}
