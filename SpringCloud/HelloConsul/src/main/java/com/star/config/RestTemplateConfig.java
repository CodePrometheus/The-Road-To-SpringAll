package com.star.config;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

//    在工厂中创建一个restTemplate对象
//    整合 restTemplate + ribbon
    @Bean
    @LoadBalanced//代表着有ribbon负载均衡的RestTemplate客户端对象
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
