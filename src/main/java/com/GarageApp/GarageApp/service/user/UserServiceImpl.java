package com.GarageApp.GarageApp.service.user;


import com.GarageApp.GarageApp.Entity.*;
import com.GarageApp.GarageApp.bo.CreateSignupRequest;
import com.GarageApp.GarageApp.bo.user.GetUserRequest;
import com.GarageApp.GarageApp.bo.user.UpdateUserRequest;
import com.GarageApp.GarageApp.bo.user.UserReviewRequest;
import com.GarageApp.GarageApp.repository.*;
import com.GarageApp.GarageApp.service.auth.UserDetailUtil;
import com.GarageApp.GarageApp.util.enums.Request;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ReviewRepository reviewRepository;

    private  final GarageRepository garageRepository;

    private final RequestRepository requestRepository;

    private final EndUserRepository endUserRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, ReviewRepository reviewRepository, GarageRepository garageRepository, RequestRepository requestRepository, EndUserRepository endUserRepository) {
        this.userRepository = userRepository;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.reviewRepository = reviewRepository;

        this.garageRepository = garageRepository;
        this.requestRepository = requestRepository;
        this.endUserRepository = endUserRepository;
    }

    @Override
    public void saveUser(CreateSignupRequest createSignupRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(createSignupRequest.getUsername());

        userEntity.setPassword(createSignupRequest.getPassword());
        userEntity.setEmail(createSignupRequest.getEmail());
        userRepository.save(userEntity);

    }

    @Override
    public void updateUser(UpdateUserRequest updateUserRequest, Long id) {
        UserEntity userEntity = userRepository.getById(id);
        userEntity.setUsername(updateUserRequest.getUsername());

        userEntity.setEmail(updateUserRequest.getEmail());

        userEntity.setPassword(bCryptPasswordEncoder.encode(updateUserRequest.getPassword()));
        userRepository.save(userEntity);
    }

    @Override
    public void addReview(Long garageId,UserReviewRequest userReviewRequest) {
        UserEntity userEntity = userRepository.findById(UserDetailUtil.userDetails().getId()).orElseThrow();

        GarageEntity garageEntity=garageRepository.findById(garageId)
                .orElseThrow();

        ReviewEntity review = new ReviewEntity();
        review.setText(userReviewRequest.getText());
        review.setStarRate(userReviewRequest.getStarRate());
        review.setGarageEntity(garageEntity);
        review.setUserEntity(userEntity);
        reviewRepository.save(review);
    }

    @Override
    public void submitRequest(Long garageId) {
        UserEntity userEntity=userRepository.findById(UserDetailUtil.userDetails().getId())
                .orElseThrow();

        EndUserEntity endUserEntity = endUserRepository.findByUserEntity(userEntity);
        GarageEntity garageEntity= garageRepository.findById(garageId)
                .orElseThrow();
        RequestEntity request= new RequestEntity();
        request.setRequestStatus(Request.WAITING);
        request.setVehicleModel(endUserEntity.getVehicleModel());
        request.setVehicleType(endUserEntity.getVehicleType());
        request.setVehicleYear(endUserEntity.getVehicleYear());
        request.setGarageEntity(garageEntity);
        request.setUserEntity(endUserEntity.getUserEntity());
        requestRepository.save(request);
    }




    @Override
    public GetUserRequest getUser(Long id) {
        UserEntity userEntity = userRepository.getById(id);
        GetUserRequest getUserRequest = new GetUserRequest();
        getUserRequest.setUsername(userEntity.getUsername());
        getUserRequest.setPassword(userEntity.getPassword());
        getUserRequest.setEmail(userEntity.getEmail());
        getUserRequest.setId(userEntity.getId());
        return getUserRequest;
    }

    @Override
    public List<GarageEntity> getAllGarages() {
        return garageRepository.findAll();
    }



    @Override
    public List<UserEntity> allUsers() {
        return null;
    }

}