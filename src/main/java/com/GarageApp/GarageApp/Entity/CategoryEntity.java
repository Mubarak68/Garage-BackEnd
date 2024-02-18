package com.GarageApp.GarageApp.Entity;

import javax.persistence.*;

@Entity
@Table(name = "garage_category")
public class CategoryEntity {

    @Id
    @Column(name = "categoryId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "carName", nullable = false)
    private String carName;


    @Column(name = "carYear", nullable = false)
    private String carYear;
}
