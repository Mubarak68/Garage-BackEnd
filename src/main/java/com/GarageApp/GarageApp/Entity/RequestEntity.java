package com.GarageApp.GarageApp.Entity;

import com.GarageApp.GarageApp.util.enums.Request;
import com.GarageApp.GarageApp.util.enums.VehicleType;

import javax.persistence.*;

@Entity
@Table(name = "garage_request")
public class RequestEntity {


    @Id
    @Column(name = "requestId", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;

    @Enumerated(EnumType.STRING)
    private Request requestStatus;

    @OneToOne
    @JoinColumn(name = "garage_id")
    private GarageEntity garageEntity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @Column(name = "vehicleYear",nullable = false)
    private String vehicleYear;


    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(name = "vehicleModel",nullable = false)
    private String vehicleModel;

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

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public Request getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(Request requestStatus) {
        this.requestStatus = requestStatus;
    }

    public GarageEntity getGarageEntity() {
        return garageEntity;
    }

    public void setGarageEntity(GarageEntity garageEntity) {
        this.garageEntity = garageEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
