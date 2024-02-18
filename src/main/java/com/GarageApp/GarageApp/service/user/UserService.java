package com.GarageApp.GarageApp.service.user;


import com.GarageApp.GarageApp.Entity.UserEntity;
import com.GarageApp.GarageApp.bo.CreateSignupRequest;
import com.GarageApp.GarageApp.bo.user.GetUserRequest;
import com.GarageApp.GarageApp.bo.user.UpdateUserRequest;


import java.util.List;

public interface UserService {

    void saveUser(CreateSignupRequest createSignupRequest);



    void updateUser(UpdateUserRequest updateUserRequest, int id);


    List<UserEntity> allUsers();
    GetUserRequest getUser(int id);
}
