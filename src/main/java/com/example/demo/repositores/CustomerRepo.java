package com.example.demo.repositores;

import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.LockerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository <CustomerEntity, Long> {

    CustomerEntity findByEmail(String email);
}
