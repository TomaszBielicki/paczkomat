package com.example.demo.controllers;

import com.example.demo.model.delivery.DeliveryRequest;
import com.example.demo.model.delivery.DeliveryResponse;
import com.example.demo.model.entity.DeliveryEntity;
import com.example.demo.model.locker.LockerRequest;
import com.example.demo.services.delivery.DeliveryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/get")
    public List<DeliveryEntity> getDeliveries(){
        return deliveryService.getDeliveries();
    }

}
