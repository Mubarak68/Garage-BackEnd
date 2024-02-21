package com.GarageApp.GarageApp.controller.auth;

import com.GarageApp.GarageApp.bo.AuthinticationResponse;
import com.GarageApp.GarageApp.bo.CreateLoginRequest;
import com.GarageApp.GarageApp.bo.CreateSignupRequest;
import com.GarageApp.GarageApp.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody CreateSignupRequest createSignupRequest){
        authService.signup(createSignupRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Created");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthinticationResponse> login(@RequestBody CreateLoginRequest createLoginRequest){
        AuthinticationResponse response=authService.login(createLoginRequest);
        HttpStatus status= HttpStatus.OK;
        if (response == null){
            status= HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity<>(response, status);
    }

//    @PostMapping("/logout")
//    public ResponseEntity<Void> logout(@RequestBody LogoutResponse logoutResponse){
//        authService.logout(logoutResponse);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}