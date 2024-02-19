package com.GarageApp.GarageApp.Entity;

import com.GarageApp.GarageApp.util.enums.Request;

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
