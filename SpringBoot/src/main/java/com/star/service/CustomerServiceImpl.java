package com.star.service;

import com.star.dao.CustomerDAO;
import com.star.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
//业务层的核心三件事
//控制事务，调用DAO，处理业务逻辑
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public void save(Customer customer) {
        customer.setId(Integer.valueOf(UUID.randomUUID().toString()));
        customerDAO.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerDAO.findAll();
    }
}
