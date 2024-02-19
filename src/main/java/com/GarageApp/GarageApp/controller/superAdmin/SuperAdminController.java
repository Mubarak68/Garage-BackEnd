package com.GarageApp.GarageApp.controller.superAdmin;

import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.service.ssadmin.SuperAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/super_admin")
public class SuperAdminController {
    private final SuperAdminService superAdminService;

    public SuperAdminController(SuperAdminService superAdminService) {
        this.superAdminService = superAdminService;
    }

    @GetMapping("/garages_list")
    public ResponseEntity<List<GarageEntity>> getAllGarages() {
        List<GarageEntity> allGarages = superAdminService.getAllGarages();
        return ResponseEntity.ok(allGarages);
    }
}
