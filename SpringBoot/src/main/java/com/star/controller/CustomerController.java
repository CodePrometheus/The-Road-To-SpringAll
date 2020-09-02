package com.star.controller;

import com.star.entity.Customer;
import com.star.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cust")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    //    save
    @GetMapping("/save")
    public void save(Customer customer) {
        customerService.save(customer);
    }

    //    findAll
    @GetMapping("/findAll")
    public String findAll(Model model) {
        List<Customer> list = customerService.findAll();
        model.addAttribute("cust", customerService);
        return "showAll";
    }


}
