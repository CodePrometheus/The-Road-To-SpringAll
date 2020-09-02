package com.star.controller;

import com.star.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//测试mvc数据传递机制
@RequestMapping("attr")
@Controller
public class AttrController {

    //    零散数据类型(8中基本类型+String+日期)
//    传递对象类型数据
//    集合类型
//    request对象传递数据  Model对象，底层封装了request对象
    @RequestMapping("test")
    public String test(Model model, HttpServletRequest request, HttpServletResponse response) {
        String name = "joy";
        User user = new User("21", "joy", 23, new Date());
        User user1 = new User("22", "joy", 23, new Date());
        User user2 = new User("32", "joy", 23, new Date());
//        快速将对象转成集合
        List<User> users = Arrays.asList(user, user1, user2);
        model.addAttribute("users", users);
        model.addAttribute("user", user);
        model.addAttribute("username", name);
//        request.setAttribute("users",users);
//        request.setAttribute("user",user);
//        request.setAttribute("username",name);
        return "attr";
    }

//    redirect传递
//    地址栏？拼接数据  session对象
    @RequestMapping("test1")
    public String test1(HttpServletRequest request) throws UnsupportedEncodingException {
        String name = "杰伦";
        User user = new User("21", "joy", 23, new Date());
        request.getSession().setAttribute("user",user);
//        转中文
        return "redirect:/attr.jsp?name=" + URLEncoder.encode(name,"UTF-8");
    }
}
