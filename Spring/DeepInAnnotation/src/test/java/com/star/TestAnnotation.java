package com.star;

import com.star.bean.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestAnnotation {


//    测试配置Bean
    @Test
    public void test1(){
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.star");
    }


}
