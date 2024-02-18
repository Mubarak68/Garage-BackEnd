package com.GarageApp.GarageApp.Entity;


import javax.persistence.*;

@Entity
@Table(name = "garage_entity")
public class GarageEntity {
    @Id
    @Column(name = "garageId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long garageId;

    @Column(name = "location", nullable = false)
    private String location;


    @Column(name = "rating", nullable = false)
    private Double rating;


    @Column(name = "specialIn",nullable = false)
    private String specialIn;




}
