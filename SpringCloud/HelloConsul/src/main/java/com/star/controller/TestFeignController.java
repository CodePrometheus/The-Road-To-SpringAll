package com.star.controller;

import com.star.clients.ProductClient;
import com.star.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestFeignController {

    @Autowired
    private ProductClient productClient;

//    test Feign
    @GetMapping("/feign/test")
    public Map<String,Object> test(){
        log.info("进入测试feign调用的方法");
//        String msg = productClient.ShowMsg();
        Map<String, Object> map = productClient.findAll();
//        log.info("调用商品服务返回的信息:[{}]" ,msg);
        log.info("调用商品服务返回的信息:[{}]" ,map);
        return map;
    }

//    test GET
    @GetMapping("/feign/test1")
    public Map<String,Object> test1(String id){
        log.info("用来测试Get方式参数传递");
        Map<String,Object> msg = productClient.findOne(id);
        log.info("调用返回信息:[{}]",msg);
        return msg;
    }

//    test POST
    @GetMapping("/feign/test2")
    public Map<String,Object> test2(String name){
        log.info("用来测试Post方式参数传递");
        Map<String,Object> msg = productClient.save(name);
        log.info("调用返回信息:[{}]",msg);
        return msg;
    }

//    测试传递对象POST
    @GetMapping("/feign/test3")
    public Map<String,Object> test3(Product product){
        log.info("用来测试Post方式参数传递对象");
        Map<String,Object> msg = productClient.update(product);
        log.info("调用返回信息:[{}]",msg);
        return msg;
    }






}
