package com.example.demo.controllers;

import com.example.demo.services.simulater.SimulateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simulate-api")
public class SimulateController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    private SimulateService simulateService;

    public SimulateController(SimulateService simulateService) {
        this.simulateService = simulateService;
    }

    @GetMapping
    public void simulateDelivery(@RequestParam String deliveryId) {
        simulateService.simulate(deliveryId);
        LOG.info("id {}", deliveryId);
    }

}

