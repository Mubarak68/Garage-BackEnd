package com.GarageApp.GarageApp.Entity;


import javax.persistence.*;

@Entity
@Table(name = "garage_entity")
public class GarageEntity {


    @Id
@Column(name = "id", nullable = false)
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long garageId;


    @Column(name = "garageName", nullable = false)
    private String garageName;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "rating", nullable = false)
    private Double rating;


    @Column(name = "specialIn",nullable = false)
    private String specialIn;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Long getGarageId() {
        return garageId;
    }

    public void setGarageId(Long garageId) {
        this.garageId = garageId;
    }

    public String getGarageName() {
        return garageName;
    }

    public void setGarageName(String garageName) {
        this.garageName = garageName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getSpecialIn() {
        return specialIn;
    }

    public void setSpecialIn(String specialIn) {
        this.specialIn = specialIn;
    }

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }
}
