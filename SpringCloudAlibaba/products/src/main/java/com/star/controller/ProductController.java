package com.star.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ProductController {

    @Value("${server.port}")
    private int port;


    @GetMapping("/product/find")
    public Map<String,Object> find(@RequestParam("id") String id){
        Map<String, Object> map = new HashMap<>();
        log.info("进入商品服务，当前端口为:[{}]",id);
        map.put("status",true);
        map.put("msg","调用成功，查询id为：" + id + ",当前处理服务的端口为:" + port);
        return map;
    }
}
