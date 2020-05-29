package com.example.demo.services.locker;

import com.example.demo.model.entity.LockerEntity;
import com.example.demo.model.locker.LockerRequest;

import java.util.List;

public interface LockerService {

    List<LockerEntity> getLocker();
    void addLocker (LockerRequest lockerRequest);

}
