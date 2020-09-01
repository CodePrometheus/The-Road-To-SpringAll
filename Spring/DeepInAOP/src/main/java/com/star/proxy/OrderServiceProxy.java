package com.star.proxy;

public class OrderServiceProxy implements OrderService {


    private OrderServiceImpl orderService = new OrderServiceImpl();

    @Override
    public void showOrder() {
        System.out.println("代理OrderServiceProxy.showOrder");
        orderService.showOrder();
    }
}
