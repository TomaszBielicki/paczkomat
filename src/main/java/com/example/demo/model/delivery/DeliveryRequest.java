package com.example.demo.model.delivery;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequest {

    private String customerId;
    private String startLockerId;
    private String endLockerId;
    private String email;
}
