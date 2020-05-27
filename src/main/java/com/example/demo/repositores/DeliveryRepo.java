package com.example.demo.repositores;

import com.example.demo.model.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository <DeliveryEntity, Long> {
}
