package com.example.demo.services.delivery;

import com.example.demo.model.delivery.DeliveryRequest;
import com.example.demo.model.delivery.DeliveryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DeliveryServiceImpl implements DeliveryService {

    private IDeliveryHandler deliveryHandler;

    @Autowired
    public DeliveryServiceImpl(DeliveryHandler deliveryHandler) {
        this.deliveryHandler = deliveryHandler;
    }

    @Override
    public DeliveryResponse addDelivery(DeliveryRequest deliveryRequest) {
        return deliveryHandler.invoke(deliveryRequest);
    }

}


