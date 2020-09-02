package com.star.controller;

import com.star.clients.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class UserController {

//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
//
//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private ProductClient productClient;

    @GetMapping("/user/getInfo")
    public Map<String, Object> getInfo(String productId){

//       第一种 通过restTemplate调用 写死
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://localhost:9098/product/find?id=" + productId, String.class);

//        第二种 通过restTemplate + ribbon负载均衡调用
//        List<ServiceInstance> products = discoveryClient.getInstances("products");
//        for (ServiceInstance product : products) {
//            log.info("服务地址:[{}]",product.getUri());
//        }

//        ServiceInstance instance = loadBalancerClient.choose("products");//默认轮询
//        log.info("当前处理服务负载均衡客户端主机为:[{}]",instance.getUri());
//        String forObject1 = restTemplate.getForObject(instance.getUri() + "/product/find?id=" + productId, String.class);

//        注解方式@LoadBalance
//        String forObject = restTemplate.getForObject("http://products/product/find?id=" + productId, String.class);

        Map<String, Object> map = productClient.find(productId);
        log.info("返回的信息:[{}]",map);
        return map;

    }


}
