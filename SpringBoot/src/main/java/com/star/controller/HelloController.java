package com.star.controller;


import com.star.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Calendar;
import java.util.List;

//解耦
@RestController
//@RestController。这被称为构造型注释。  （@Controller实例化当前类为一个控制器 + @ResponseBody转json）
// 实例化当前对象为一个控制器对象，并将类上所有方法的返回值转为json，响应给浏览器
// 它为阅读代码的人和Spring提供了提示，提示该类起特定的作用。
// 在这种情况下，我们的类是一个Web @Controller，因此Spring在处理传入的Web请求时会考虑使用它。


@RequestMapping("/hello")
//@RequestMapping注解提供“路由”信息。它告诉Spring，任何带有/路径的HTTP请求都应映射到home方法。
// @RestController注解告诉Spring将结果字符串直接呈现回调用方。
//加入访问路径  修饰范围：类（加入命名空间） 方法上（指定具体路径）


//@Import(User.class)
public class HelloController {

    @GetMapping("/hello")  //限定请求方式只能是Get，并指定路径 修饰访问：方法上
    //此外还有  @PostMapping @DeleteMapping @PutMapping

    public String hello() {
        System.out.println("Hello SpringBoot");
//        System.out.println(user);
//        System.out.println(calendar.getTime());
//        System.out.println(calendar);
//        System.out.println(calendar1);
//        System.out.println(calendar == calendar1);
        System.out.println("name:" + name);
        System.out.println(bir);
        System.out.println(port);
        for (String str : strs) {
            System.out.println(str);
        }
        q.forEach(q -> System.out.println(q));

        return "Hello SpringBoot";
    }

    @Value("${name}")//取配置文件中的信息 ${}
    private String name;

    @Value("${server.port}")
    private int port;

    @Value("${bir}")
    private Date bir;

    @Value("${strs}")
    private String[] strs;

    @Value("${q}")
    private List<String> q;

//    @Autowired
//    private Calendar calendar;
//
//    @Autowired
//    private Calendar calendar1;
//
//    @Autowired
//    private User user;


}
