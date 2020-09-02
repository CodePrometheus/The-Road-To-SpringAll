package com.star.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Calendar;

@Configuration
public class BeanConfigs {

    @Bean()//用来将方法返回值交给springboot管理   在工厂中默认标识：首字母小写
//    @Scope("prototype")//多例   默认为singleton
    public Calendar getCalendar() {
        return Calendar.getInstance();
    }

}
