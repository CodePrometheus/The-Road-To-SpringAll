package com.star.controller;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    @Autowired//工厂中已经有了，注入具有ribbon特性的restTemplate
    private RestTemplate restTemplate;

    @GetMapping("/user/showProductMsg")
    public String showProductMsg(){
//        第一种服务调用方式   服务地址:http://localhost:9998/product/showMsg
        RestTemplate restTemplate = new RestTemplate();
        String msg = restTemplate.getForObject("http://localhost:9998/product/showMsg", String.class);
        log.info("调用成功返回的信息：[{}]",msg);
        return msg;
    }

    @GetMapping("user/findAllProduct")
    public String findAllProduct(){
        log.info("加入用户服务");

//        第一种  使用restTemplate方式直接调用 也即加上url地址写死
//        没有负载均衡，代码写死不利于维护，服务宕机不能高效剔除
//        RestTemplate restTemplate = new RestTemplate();
//        String forObject = restTemplate.getForObject("http://localhost:9998/product/findAll", String.class);
//        String forObject = restTemplate.getForObject("http://" + randomHost() + "/product/findAll", String.class);
//        log.info("商品服务调用返回结果:[{}]",forObject);

//        第二种 ribbon调用  discovery client  loadBalancelient @LoadBalance
//        根据服务名去注册中心拿到服务所对应的节点和端口  获取服务列表
//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("products");
//        for (ServiceInstance serviceInstance : serviceInstances){
//            System.out.println(serviceInstance.getPort());
//            System.out.println(serviceInstance.getHost());
//        }
//        return serviceInstances;


//        第三种  LoadBalacneClient  默认为轮询策略
//        ServiceInstance serviceInstance = loadBalancerClient.choose("products");
//        System.out.println(serviceInstance.getPort());
//        System.out.println(serviceInstance.getHost());
//        String forObject = restTemplate.getForObject("http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/product/findAll", String.class);

//        第四种方式  @loadBalanced   + RestTemplate
//        products就是在consul注册中心的服务名
        String forObject = restTemplate.getForObject("http://products/product/findAll", String.class);

        return forObject;

//        IRule iRule;
//        RoundRobinRule roundRobinRule;

//        return serviceInstance;

//        return forObject;
    }

//    手动负载均衡
    public static String randomHost(){
        List<Object> list = new ArrayList<>();
        list.add("localhost:9998");
        list.add("localhost:9997");
        int i = new Random().nextInt(2);
        return (String) list.get(i);
    }

    public static void main(String[] args) {
        System.out.println(randomHost());
    }


}
