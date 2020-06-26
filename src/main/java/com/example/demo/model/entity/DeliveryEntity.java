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
    private String adressedId;
    private String recieverId;
    private String startLockerId;
    private String endLockerId;
    private String status;

}
