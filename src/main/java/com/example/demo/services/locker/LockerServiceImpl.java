package com.example.demo.services.locker;

import com.example.demo.model.entity.LockerEntity;
import com.example.demo.model.locker.LockerRequest;
import com.example.demo.repositores.LockerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;


import java.util.List;
import java.util.UUID;

@Service
public class LockerServiceImpl implements LockerService {

    private final LockerRepo lockerRepo;

    @Autowired
    public LockerServiceImpl (LockerRepo lockerRepo){
        this.lockerRepo = lockerRepo;
    }

    @Override
    public List<LockerEntity> getLocker() {
        return lockerRepo.findAll();
    }

    @Override
    public void addLocker(LockerRequest lockerRequest) {

        String lockerId = UUID.randomUUID().toString();
        LockerEntity lockerEntity = new ModelMapper().map(lockerRequest, LockerEntity.class);
        lockerEntity.setLockerId(lockerId);
        lockerRepo.save(lockerEntity);
    }

    public void changeLockerSpace(){

    }

}
