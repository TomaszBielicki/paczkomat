package com.example.demo.services.delivery;

import com.example.demo.model.delivery.DeliveryRequest;
import com.example.demo.model.delivery.DeliveryResponse;
import com.example.demo.model.entity.CustomerEntity;
import com.example.demo.model.entity.DeliveryEntity;
import com.example.demo.model.entity.LockerEntity;
import com.example.demo.repositores.CustomerRepo;
import com.example.demo.repositores.DeliveryRepo;
import com.example.demo.repositores.LockerRepo;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
public class DeliveryHandler implements IDeliveryHandler {
    private static final String PROGRESS = "WAITING";
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private DeliveryRepo deliveryRepo;
    private LockerRepo lockerRepo;
    private CustomerRepo customerRepo;

    @Autowired
    public DeliveryHandler(DeliveryRepo deliveryRepo,
                               LockerRepo lockerRepo,
                               CustomerRepo customerRepo) {
        this.deliveryRepo = deliveryRepo;
        this.lockerRepo = lockerRepo;
        this.customerRepo = customerRepo;
    }

    @Override
    public DeliveryResponse invoke(DeliveryRequest deliveryRequest) {

        LOG.info("DeliveryRequest invoke start");

        if (lockValidator(deliveryRequest)) return null;
        CustomerEntity receiver = receiverValidator(deliveryRequest);
        DeliveryResponse deliveryResponse = createDelivery(deliveryRequest, receiver);
        deliveryResponse.setMessage("Has been send");
        deliveryResponse.setData(new Date().toString());
        return deliveryResponse;
    }

    @Override
    public List<DeliveryEntity> getDeliveries() {
        return deliveryRepo.findAll();
    }


    private boolean lockValidator(DeliveryRequest deliveryRequest) {
        LockerEntity locker = lockerRepo.findByLockerId(deliveryRequest.getStartLockerId());
        if (!(locker.getSpace() > 0)) {
            LOG.error("There is no space in Locker id: {}", locker.getId());
            return true;
        }
        locker.setSpace(locker.getSpace() - 1);
        return false;
    }

    private CustomerEntity receiverValidator(DeliveryRequest deliveryRequest) {
        CustomerEntity receiver = customerRepo.findByEmail(deliveryRequest.getEmail());
        if (receiver == null) {
            receiver = new CustomerEntity();
            receiver.setClientId(UUID.randomUUID().toString());
            receiver.setEmail(deliveryRequest.getEmail());
            customerRepo.save(receiver);
        }
        return receiver;
    }

    private DeliveryResponse createDelivery(DeliveryRequest deliveryRequest, CustomerEntity receiver) {
        DeliveryEntity createDeliveryEntity = new DeliveryEntity();
        createDeliveryEntity.setDeliveryId(UUID.randomUUID().toString());
        createDeliveryEntity.setAdressedId(deliveryRequest.getCustomerId());
        createDeliveryEntity.setRecieverId(receiver.getClientId());
        createDeliveryEntity.setStartLockerId(deliveryRequest.getStartLockerId());
        createDeliveryEntity.setEndLockerId(deliveryRequest.getEndLockerId());
        createDeliveryEntity.setStatus(PROGRESS);
        deliveryRepo.save(createDeliveryEntity);
        return new ModelMapper().map(createDeliveryEntity, DeliveryResponse.class);
    }
}
