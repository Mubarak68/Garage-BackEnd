package com.GarageApp.GarageApp.service.auth;


import com.GarageApp.GarageApp.bo.AuthinticationResponse;
import com.GarageApp.GarageApp.bo.CreateLoginRequest;
import com.GarageApp.GarageApp.bo.CreateSignupRequest;

public interface AuthService {
    void signup(CreateSignupRequest createSignupRequest);

    AuthinticationResponse login(CreateLoginRequest createLoginRequest);


}