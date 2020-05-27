package com.example.demo.repositores;

import com.example.demo.model.entity.LockerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LockerRepo extends JpaRepository<LockerEntity, Long> {
}
