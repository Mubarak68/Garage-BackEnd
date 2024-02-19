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

    @ManyToOne
    @JoinColumn(name = "garage_id")
    private GarageEntity garageEntity;

    @OneToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Double getStarRate() {
        return starRate;
    }

    public void setStarRate(Double starRate) {
        this.starRate = starRate;
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
