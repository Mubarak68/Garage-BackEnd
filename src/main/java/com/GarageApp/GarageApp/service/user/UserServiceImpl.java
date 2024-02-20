package com.GarageApp.GarageApp.service.user;


import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.Entity.ReviewEntity;
import com.GarageApp.GarageApp.Entity.UserEntity;
import com.GarageApp.GarageApp.bo.CreateSignupRequest;
import com.GarageApp.GarageApp.bo.user.GetUserRequest;
import com.GarageApp.GarageApp.bo.user.UpdateUserRequest;
import com.GarageApp.GarageApp.bo.user.UserReviewRequest;
import com.GarageApp.GarageApp.repository.ReviewRepository;
import com.GarageApp.GarageApp.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ReviewRepository reviewRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder,  ReviewRepository reviewRepository) {
        this.userRepository = userRepository;

        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.reviewRepository = reviewRepository;

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
    public void addReview(UserReviewRequest userReviewRequest) {
        ReviewEntity review = new ReviewEntity();
        review.setText(userReviewRequest.getText());
        review.setStarRate(userReviewRequest.getStarRate());
        reviewRepository.save(review);
;
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
    public List<UserEntity> allUsers() {
        return null;
    }

}