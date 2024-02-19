package com.GarageApp.GarageApp.bo.garage;

public class CreateGarageRequest {


    private String garageName;
    private String location;
    private Double rating;

    private String specialIn;



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



}
