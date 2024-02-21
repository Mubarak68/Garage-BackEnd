package com.GarageApp.GarageApp.controller.admin;

import com.GarageApp.GarageApp.Entity.RequestEntity;
import com.GarageApp.GarageApp.bo.user.UpdateStatusRequest;
import com.GarageApp.GarageApp.service.admin.AdminService;
import com.GarageApp.GarageApp.service.rquest.RequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")

public class AdminController {

    private final AdminService adminService;

    private final RequestService requestService;

    public AdminController(AdminService adminService, RequestService requestService) {
        this.adminService = adminService;
        this.requestService = requestService;
    }


    @PatchMapping("/update-status")
    public ResponseEntity<String> statusRequest(@RequestParam Long requestId, @RequestBody UpdateStatusRequest updateStatusRequest) {
        adminService.updateStatusRequest(requestId, updateStatusRequest);
        return ResponseEntity.ok("User has updated status successfully!!! ");
    }



    @GetMapping("/getAllRequest")
    public ResponseEntity<List<RequestEntity>> getAllStatusRequest() {
        List<RequestEntity> requestEntities= requestService.getAllRequest();
        return ResponseEntity.ok(requestEntities);
    }

}
