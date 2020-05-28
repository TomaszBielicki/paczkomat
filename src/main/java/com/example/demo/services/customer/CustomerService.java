package com.example.demo.services.customer;

import com.example.demo.model.customer.CustomerRequest;
import com.example.demo.model.entity.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CustomerService {

    List<CustomerEntity> getCustomer();
    void addCustomer(CustomerRequest customerRequest);
}
