package com.example.demo.repositores;

import com.example.demo.model.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface DeliveryRepo extends JpaRepository <DeliveryEntity, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE DeliveryEntity d SET d.status = 'PROGRESS' WHERE d.deliveryId = :deliveryId")
    void setProgressDeliveryStatusById (@Param("deliveryId")String deliveryId);

    @Transactional
    @Modifying
    @Query("UPDATE DeliveryEntity d SET d.status = 'RECEIVED' WHERE d.deliveryId = :deliveryId")
    void setReceivedDeliveryStatusById (@Param("deliveryId")String deliveryId);

    Optional<DeliveryEntity> findByDeliveryId(String deliverId);
}
