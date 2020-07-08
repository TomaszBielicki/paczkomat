package com.example.demo.services.delivery;

import com.example.demo.model.delivery.DeliveryRequest;
import com.example.demo.model.delivery.DeliveryResponse;
import com.example.demo.model.entity.DeliveryEntity;

import java.util.List;

public interface IDeliveryHandler {
    DeliveryResponse invoke(DeliveryRequest deliveryRequest);

    List<DeliveryEntity> getDeliveries();
}
