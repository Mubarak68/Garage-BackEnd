package com.GarageApp.GarageApp.bo;


public class CreateSignupRequest {
    private String username;
    private String email;
    private String password;

    private String VehicleName;
    private String VehicleYear;

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String vehicleName) {
        VehicleName = vehicleName;
    }

    public String getVehicleYear() {
        return VehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        VehicleYear = vehicleYear;
    }





    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
