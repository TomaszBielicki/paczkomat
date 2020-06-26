package com.example.demo.repositores;

import com.example.demo.model.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface DeliveryRepo extends JpaRepository <DeliveryEntity, Long> {
}
