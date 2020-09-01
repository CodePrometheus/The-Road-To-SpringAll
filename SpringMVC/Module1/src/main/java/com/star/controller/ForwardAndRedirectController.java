package com.star.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//测试forward跳转
@Controller
@RequestMapping("/for")
public class ForwardAndRedirectController {

    //    跳转到页面
//    默认的controller跳转到jsp页面就是forward跳转
    @RequestMapping("/test")
    public String test() {
        System.out.println("默认的跳转");
        return "index";
    }

    //    重定向要使用关键字 redirect
//    使用语法：redirect:/视图全名
//    不会经过视图解析器
    @RequestMapping("/red")
    public String re() {
        System.out.println("重定向");
        return "redirect:/index.jsp";
    }

    //    forward跳转到相同controller类中的不同方法
//    使用关键字 forward:/跳转controller类上的@RequestMapping路径/跳转类中指定方法上的@RequestMapping路径
    @RequestMapping("test1")
    public String test1() {
        System.out.println("跳转到相同controller类中的不同方法");
        return "forward:/for/test";
    }

    //    使用redirect跳转到相同controller类中的不同方法
//    使用关键字 redirect:/跳转controller类上的@RequestMapping路径/跳转类中指定方法上的@RequestMapping路径
    @RequestMapping("test2")
    public String test2() {
        System.out.println("重定向到相同controller类中的不同方法");
        return "redirect:/for/red";
    }

    //    跳转不同controller方法
    @RequestMapping("test3")
    public String test3() {
        System.out.println("跳转不同controller");
        return "forward:/lei/hello";
    }

    //    重定向
    @RequestMapping("test4")
    public String test4() {
        System.out.println("跳转不同controller");
        return "redirect:/lei/save";
    }


}
