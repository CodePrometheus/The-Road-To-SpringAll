package com.star.clients;

import com.star.entity.Product;
import com.star.fallback.ProductClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

//openfeign客户端调用商品服务
@FeignClient(value = "products",fallback = ProductClientFallBack.class)//标识当前接口是 一个 feign组件
public interface ProductClient {

    @GetMapping("/product/showMsg")
    String ShowMsg();

    @GetMapping("/product/findAll")
    Map<String,Object> findAll();

    @GetMapping("/product/findOne")  //openfeign的GEt传递时，参数变量必须通过@RequestParam修饰
    Map<String,Object> findOne(@RequestParam("productId") String productId);

//    test POST
    @PostMapping("/product/save")
    Map<String,Object> save(@RequestParam("name")String name);

    @PostMapping("/product/update")//传递对象
    Map<String,Object> update(@RequestBody Product product);


}
