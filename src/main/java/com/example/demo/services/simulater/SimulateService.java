package com.example.demo.services.simulater;

import com.example.demo.model.entity.DeliveryEntity;
import com.example.demo.model.entity.LockerEntity;
import com.example.demo.repositores.DeliveryRepo;
import com.example.demo.repositores.LockerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SimulateService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private DeliveryRepo deliveryRepo;
    private LockerRepo lockerRepo;

    @Autowired
    public SimulateService(DeliveryRepo deliveryRepo,
                           LockerRepo lockerRepo) {

        this.deliveryRepo = deliveryRepo;
        this.lockerRepo = lockerRepo;
    }


    public boolean simulate (String deliverId){

       Optional<DeliveryEntity> oDelivery = deliveryRepo.findByDeliveryId(deliverId);

        DeliveryEntity deliveryEntity = oDelivery.get();

        // Progress state
        unLock(deliveryEntity.getStartLockerId());
        deliveryRepo.setProgressDeliveryStatusById(deliverId);
        LOG.info("Delivery {} in progress", deliverId);

        // Received state
        inLock(deliveryEntity.getEndLockerId());
        deliveryRepo.setReceivedDeliveryStatusById(deliverId);
        LOG.info("Delivery {} is Received", deliverId);
        return true;
    }

    private void unLock(String startLockerId) {
        LockerEntity locker = lockerRepo.findByLockerId(startLockerId);
        locker.setSpace(locker.getSpace() + 1);
    }

    private void inLock(String endLockerId) {
        LockerEntity locker = lockerRepo.findByLockerId(endLockerId);
        locker.setSpace(locker.getSpace() - 1);
    }

    
}
