package com.GarageApp.GarageApp.Entity;

import com.GarageApp.GarageApp.util.enums.Request;

import javax.persistence.*;

@Entity
@Table(name = "garage_request")
public class RequestEntity {


    @Id
    @Column(name = "requestId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int requestId;

    @Enumerated(EnumType.STRING)
    private Request requestStatus;
}
