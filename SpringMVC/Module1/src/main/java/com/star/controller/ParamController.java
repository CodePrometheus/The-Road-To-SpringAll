package com.star.controller;

//参数接收

import com.star.entity.User;
import com.star.vo.CollectionVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("param")
public class ParamController {

    //    零散类型参数接收
//    路径为http://localhost:8080/mvc/param/test?name=joy
    @RequestMapping("/test")
    public String test(String name, Double price, Boolean sex, Date bir) {
        System.out.println(name);
        System.out.println(price);
        System.out.println(sex);
        System.out.println(bir);
        return "index";
    }

    //    接收对象类型，直接将要接收
//    spring MVC封装对象时直接根据传递参数key与对象中属性名一致自动封装对象
    @RequestMapping("test1")
    public String test1(User user, String name) {
        System.out.println(user);
        System.out.println(name);
        return "index";
    }

    //   数组类型参数接收，将要接收数组类型直接声明为方法的形参即可
//    保证请求参数多个参数key与声明数组变量名一致，放入同一数组中
    @RequestMapping("test2")
    public String test2(String[] q) {
        for (String s : q) {
            System.out.println(s);
        }
        return "index";
    }

    //    集合类型参数接收
//    不能直接通过形参列表方式收集集合类型参数，要接收集合类型的参数必须将集合放入对象中接收才可以
//    推荐放在vo对象接收集合类型，vo=value object 值对象
    @RequestMapping("test3")
    public String test3(CollectionVO collectionVO) {
        collectionVO.getList().forEach(l -> System.out.println(l));
        return "index";
    }

    @RequestMapping("test4")
    public String test4(CollectionVO collectionVO) {
        collectionVO.getMap().forEach((k, v) -> System.out.println(k + v));
        return "index";
    }

//    @RequestMapping("test5")
}
