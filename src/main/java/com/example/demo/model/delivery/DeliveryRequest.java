package com.example.demo.model.delivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequest {

    private String deliveryId;
    private String customerId;
    private String adressedId;
    private String lockerId;
    private String status;
}
