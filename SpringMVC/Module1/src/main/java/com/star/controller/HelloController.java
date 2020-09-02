package com.star.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("lei")
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
//        收集数据

//        调用业务方法
        System.out.println("hello mvc");
//        处理响应
        return "index";//页面逻辑名
    }


    @RequestMapping("save")
    public String save(){
        System.out.println("saving");
        return "index";
    }

}
