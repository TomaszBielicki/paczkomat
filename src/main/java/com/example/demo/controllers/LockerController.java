package com.example.demo.controllers;

import com.example.demo.model.entity.LockerEntity;
import com.example.demo.model.locker.LockerRequest;
import com.example.demo.services.locker.LockerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locker-api")
public class LockerController {


    private LockerService lockerService;

    @Autowired
    public LockerController (LockerService lockerService){
        this.lockerService = lockerService;
    }

    @GetMapping
    public List<LockerEntity> getLocker(){
        return lockerService.getLocker();
    }

    @PostMapping
    public void addLocker(@RequestBody @Validated LockerRequest lockerRequest){
        lockerService.addLocker(lockerRequest);

    }
}
