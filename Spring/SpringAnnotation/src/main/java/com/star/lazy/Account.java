package com.star.lazy;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class Account {
    public Account(){
        System.out.println("延迟加载");
    }
}
