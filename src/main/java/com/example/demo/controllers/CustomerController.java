package com.example.demo.controllers;

import com.example.demo.model.customer.CustomerRequest;
import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/customer-api")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){this.customerService = customerService;}

    @GetMapping
    public List<CustomerEntity> getCustomer(){return customerService.getCustomer();}

    @PostMapping
    public void addCustomer(@RequestBody @Validated CustomerRequest customerRequest){
        customerService.addCustomer(customerRequest);

    }
}
