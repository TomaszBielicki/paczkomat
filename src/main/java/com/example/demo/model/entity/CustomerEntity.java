package com.example.demo.model.entity;


import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String clientId;
    private String name;
    private String surname;
    private String email;

    @OneToOne
    private DeliveryEntity deliveryEntity;

}
