package com.GarageApp.GarageApp.service.user;


import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.Entity.UserEntity;
import com.GarageApp.GarageApp.bo.CreateSignupRequest;
import com.GarageApp.GarageApp.bo.user.GetUserRequest;
import com.GarageApp.GarageApp.bo.user.UpdateStatusRequest;
import com.GarageApp.GarageApp.bo.user.UpdateUserRequest;
import com.GarageApp.GarageApp.bo.user.UserReviewRequest;


import java.util.List;

public interface UserService {

    void saveUser(CreateSignupRequest createSignupRequest);



    void updateUser(UpdateUserRequest updateUserRequest, Long id);

    void addReview(Long garageId, UserReviewRequest UserReviewRequest);
    void submitRequest(Long garageId);


    List<UserEntity> allUsers();
    GetUserRequest getUser(Long id);
    List<GarageEntity> getAllGarages();
}
