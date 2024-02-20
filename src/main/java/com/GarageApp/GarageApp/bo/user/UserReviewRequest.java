package com.GarageApp.GarageApp.bo.user;

import javax.persistence.Column;

public class UserReviewRequest {
    private String text;
    private Double starRate;
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



}
