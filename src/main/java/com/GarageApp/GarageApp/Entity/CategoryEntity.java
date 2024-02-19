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

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getCarYear() {
        return carYear;
    }

    public void setCarYear(String carYear) {
        this.carYear = carYear;
    }
}
