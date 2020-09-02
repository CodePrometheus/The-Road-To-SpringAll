package com.star.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.star.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController//响应json给浏览器
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;

//    模拟熔断
    @GetMapping("/product/break")
//    @HystrixCommand(fallbackMethod = "testBreakFallback")//通过HystrixCommand降级处理指出出错的方法
    @HystrixCommand(defaultFallback = "testBreakFallback")
    public String testBreak(Integer id){
        if (id <= 0){
            throw new RuntimeException("非法参数，id不能小于0");
        }
        return "访问成功，当前查询的id为:" + id;
    }

//    触发熔断的fallback方法
//    public String testBreakFallback(Integer id){
//        return "当前传入的参数id:" + id + ",不是有效参数，触发熔断";
//    }

//    默认熔断方法
    public String testBreakFallback(){
        return "服务不可用，触发熔断";
    }


    //    保存对象test3
    @PostMapping("/product/update")
    public Map<String,Object> update(@RequestBody Product product) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Map<String, Object> map = new HashMap<>();
        log.info("商品服务，接收到的商品信息为:[{}]" ,product);
        map.put("status",true);
        map.put("msg","根据name保存商品成功,当前端口" + port);
        map.put("product",product);
        return map;
    }


    //    保存一个
    @PostMapping("/product/save")
    public Map<String,Object> save(String name){
        Map<String, Object> map = new HashMap<>();
        log.info("商品服务，保存商品name为:[{}]" ,map);
        map.put("status",true);
        map.put("msg","根据name保存商品成功,当前端口" + port);
        map.put("name",name);
        return map;
    }


//    找到一个 test1
    @GetMapping("/product/findOne")
    public Map<String,Object> findOne(String productId){
        Map<String, Object> map = new HashMap<>();
        log.info("商品服务，接收到商品ID为:[{}]" ,map);
        map.put("status",true);
        map.put("msg","根据id查询商品成功,当前端口" + port);
        map.put("pruductId",productId);
        return map;
    }


//    商品信息
    @GetMapping("/product/showMsg")
    public String showMsg(){
        log.info("展示商品信息");
        return "商品信息，当前服务的端口" + port;
    }

//    查询所有
    @GetMapping("/product/findAll")
    public Map<String,Object> findAll() {
        log.info("进入商品服务，当前服务的端口：[{}]", port);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "服务调用成功，端口号为" + port);
        map.put("status", true);//表示查询成功
        return map;
    }

}
