package com.star.fallback;

import com.star.clients.ProductClient;
import com.star.entity.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ProductClientFallBack implements ProductClient {

    private Map<String,Object> result = new HashMap<>();

    @Override
    public String ShowMsg() {
        return "当前服务被降级";
    }

    @Override
    public Map<String, Object> findAll() {
        result.put("status","false");
        result.put("msg","当前服务findAll被降级");
        return result;
    }

    @Override
    public Map<String, Object> findOne(String productId) {
        result.put("status","false");
        result.put("msg","当前服务findOne被降级");
        return result;
    }

    @Override
    public Map<String, Object> save(String name) {
        result.put("status","false");
        result.put("msg","当前服务save被降级");
        return result;
    }

    @Override
    public Map<String, Object> update(Product product) {
        result.put("status","false");
        result.put("msg","当前服务update被降级");
        return result;
    }
}
