package com.example.demo.services.delivery;

import com.example.demo.model.delivery.DeliveryRequest;
import com.example.demo.model.delivery.DeliveryResponse;

public interface DeliveryService {
    DeliveryResponse addDelivery(DeliveryRequest deliveryRequest);
}
