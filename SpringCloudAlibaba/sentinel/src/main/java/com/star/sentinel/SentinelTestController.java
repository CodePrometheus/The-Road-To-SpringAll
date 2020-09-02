package com.star.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaojing
 */
@RestController
@Slf4j
public class SentinelTestController {

    @GetMapping("/hello")
    @SentinelResource(value = "resource",blockHandler = "testBlockHandle",fallback = "testFallBack")
    public String hello(int id) {
        if (id < 0) throw new RuntimeException("非法参数");
        log.info("hello");
        return "Hello";
    }

//    testFallBack处理
    public String testFallBack(int id){
        return id + ",为非法参数fallback";
    }

//    对异常的处理，且判断降级类型
    public String testBlockHandle(int id, BlockException blockException){
        if (blockException instanceof FlowException){//instanceof是Java中的二元运算符，
            // 左边是对象，右边是类；当对象是右边类或子类所创建对象时，返回true；
            // 否则，返回false
            return "被限流处理" + blockException.getClass().getSimpleName();//类的简名
        }
        if (blockException instanceof DegradeException){
            return "被降级处理" + blockException.getClass().getSimpleName();
        }
        return "当前服务失效";
    }


    @GetMapping(value = "/aa")
    @SentinelResource("aa")
    public String aa(int b, int a) {
        return "Hello test";
    }

    @GetMapping(value = "/test")
    public String test1() {
        return "Hello test";
    }

}
