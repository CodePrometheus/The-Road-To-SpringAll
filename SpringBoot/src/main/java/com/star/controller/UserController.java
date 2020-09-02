package com.star.controller;

import com.star.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller  //不能再使用@RestController注解
@RequestMapping("user")
public class UserController {

    @GetMapping("all")
    public String All(HttpServletRequest request, Model model) {
        System.out.println("查询所有");

//        获取并解析含有html标签数据
        model.addAttribute("name", "joy");
        model.addAttribute("username", "<a href=''>linda</a>");

//        展示对象数据
        model.addAttribute("user", new User("21", "yoga", 18, new Date()));

//        展示多个
        List<User> users = Arrays.asList(new User("21", "lenovo", 30, new Date())
                , new User("22", "code", 10, new Date()));
        model.addAttribute("users", users);

        return "index";//逻辑名  classpath:/templates/逻辑名.html    必须经过控制器转换
    }

    @GetMapping("del")
    @ResponseBody
    public String Del(String id, String name) {
        System.out.println("id = " + id);
        return id + "已经删除的姓名为" + name;
    }
}
