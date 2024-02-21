package com.GarageApp.GarageApp.Entity;

import com.GarageApp.GarageApp.util.enums.VehicleType;

import javax.persistence.*;

@Entity
@Table(name = "end_user")
public class EndUserEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "vehicleYear",nullable = false)
    private String vehicleYear;


    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(name = "vehicleModel",nullable = false)
    private String vehicleModel;

    @OneToOne(cascade = CascadeType.ALL)
    private UserEntity userEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
