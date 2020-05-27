package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class DeliveryEntity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String deliveryId;
    private String senderId;
    private String adressedId;
    private String lockerId;
    private String status;

    @ManyToOne
    private LockerEntity lockerEntity;

    @OneToOne
    private CustomerEntity customerEntity;
}
