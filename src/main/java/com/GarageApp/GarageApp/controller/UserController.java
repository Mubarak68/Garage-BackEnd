package com.GarageApp.GarageApp.controller;

import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.Entity.UserEntity;
import com.GarageApp.GarageApp.bo.category.CreateCategoryRequest;
import com.GarageApp.GarageApp.bo.user.GetUserRequest;
import com.GarageApp.GarageApp.bo.user.UpdateUserRequest;
import com.GarageApp.GarageApp.bo.user.UserRequestSubmission;
import com.GarageApp.GarageApp.bo.user.UserReviewRequest;
import com.GarageApp.GarageApp.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;

    }

    @GetMapping("/user-list")
    public List<UserEntity> getAllUsers() {
        return userService.allUsers();
    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest, @RequestParam Long id) {
        userService.updateUser(updateUserRequest, id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-user")
    public ResponseEntity<GetUserRequest> getUser(@RequestParam Long id) {
        GetUserRequest getUserRequest = userService.getUser(id);
        return ResponseEntity.ok().body(getUserRequest);
    }

    @PostMapping("/add-review")
    public ResponseEntity<String> addReview(@RequestBody UserReviewRequest UserReviewRequest) {
        userService.addReview(UserReviewRequest);
        return ResponseEntity.ok("User added a Review !!! ");
    }

    @PostMapping("/request")
    public ResponseEntity<String> submitRequest(@RequestParam Long garageID,
                                                @RequestBody UserRequestSubmission userRequestSubmission) {
        userService.submitRequest(garageID,userRequestSubmission);
        return ResponseEntity.ok("User added a Review !!! ");
    }
    @GetMapping("/garages")
    public ResponseEntity<List<GarageEntity>> getAllGarages() {
        List<GarageEntity> allGarages = userService.getAllGarages();
        return ResponseEntity.ok(allGarages);
    }

}