package com.example.demo.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class LockerEntity {

   @Id
   @GeneratedValue (strategy = GenerationType.IDENTITY)
   private long id;

   private String lockerId;
   private String city;
   private String space;

   @OneToMany
   private List<DeliveryEntity> deliveryEntity = new ArrayList<>();


}