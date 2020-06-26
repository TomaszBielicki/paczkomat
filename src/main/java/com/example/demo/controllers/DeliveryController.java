package com.example.demo.controllers;

import com.example.demo.model.delivery.DeliveryRequest;
import com.example.demo.model.delivery.DeliveryResponse;
import com.example.demo.model.locker.LockerRequest;
import com.example.demo.services.delivery.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delivery-api")
public class DeliveryController {

    private DeliveryService deliveryService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService){this.deliveryService= deliveryService;}

    @PostMapping("/send")
    public DeliveryResponse addDelivery(@RequestBody @Validated DeliveryRequest deliveryRequest){
        return deliveryService.addDelivery(deliveryRequest);
    }


}
