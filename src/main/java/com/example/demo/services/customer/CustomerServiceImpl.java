package com.example.demo.services.customer;

import com.example.demo.model.customer.CustomerRequest;
import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.LockerEntity;
import com.example.demo.model.locker.LockerRequest;
import com.example.demo.repositores.CustomerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo){this.customerRepo = customerRepo;}

   @Override
    public List<CustomerEntity> getCustomer() {return customerRepo.findAll();}

    @Override
    public void addCustomer(CustomerRequest customerRequest) {

        String customerId = UUID.randomUUID().toString();
        CustomerEntity customerEntity = new ModelMapper().map(customerRequest, CustomerEntity.class);
        customerEntity.setClientId(customerId);
        customerRepo.save(customerEntity);
    }
}
