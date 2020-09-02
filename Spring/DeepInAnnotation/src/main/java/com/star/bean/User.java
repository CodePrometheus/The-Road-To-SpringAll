package com.star.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;

@Configuration
public class User {

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public Connection connection() {
//        Class.forName("com.mysql.cj.jdbc.mysql");
        return null;
    }

}
