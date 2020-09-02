package com.star.service;

import com.star.entity.Customer;

import java.util.List;

public interface CustomerService {

    void save(Customer customer);

    List<Customer> findAll();
}
