package com.GarageApp.GarageApp.Entity;


import javax.persistence.*;

@Entity
@Table(name = "garage_review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "starRate", nullable = false)
    private Double starRate;
}