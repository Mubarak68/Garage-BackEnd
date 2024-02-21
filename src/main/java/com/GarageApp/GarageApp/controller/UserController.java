package com.GarageApp.GarageApp.controller;

import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.Entity.UserEntity;
import com.GarageApp.GarageApp.bo.user.*;
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
    public ResponseEntity<String> submitRequest(@RequestParam Long garageID) {
        userService.submitRequest(garageID);
        return ResponseEntity.ok("User added a Request !!! ");
    }
    @GetMapping("/garages")
    public ResponseEntity<List<GarageEntity>> getAllGarages() {
        List<GarageEntity> allGarages = userService.getAllGarages();
        return ResponseEntity.ok(allGarages);
    }

    @PatchMapping("/update-status")
    public ResponseEntity<String> statusRequest(@RequestParam Long requestId, @RequestBody UpdateStatusRequest updateStatusRequest) {
        userService.updateStatusRequest(requestId,updateStatusRequest);
        return ResponseEntity.ok("User has updated status successfully!!! ");
    }

}