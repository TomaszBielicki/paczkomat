package com.example.demo.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
public class CustomerEntity {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String clientId;
    private String name;
    private String surname;
    private String email;

    @JsonIgnore
    @OneToOne
    private DeliveryEntity deliveryEntity;

}
