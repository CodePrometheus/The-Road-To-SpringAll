package com.star.dao;

import com.star.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CustomerDAO {

    void save(Customer customer);

    List<Customer> findAll();
}
