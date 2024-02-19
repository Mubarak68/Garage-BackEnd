package com.GarageApp.GarageApp.controller.superAdmin;

import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.bo.garage.CreateGarageRequest;
import com.GarageApp.GarageApp.service.superadmin.SuperAdminService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/super_admin")
public class SuperAdminController {
    private final SuperAdminService superAdminService;

    public SuperAdminController(SuperAdminService superAdminService) {
        this.superAdminService = superAdminService;
    }



    @PostMapping("/add-garage")
    public ResponseEntity<String> addGarage(@RequestBody CreateGarageRequest createGarageRequest) {
        superAdminService.addGarage(createGarageRequest);
        return ResponseEntity.ok("Added a Garage");
    }





    @GetMapping("/garages_list")
    public ResponseEntity<List<GarageEntity>> getAllGarages() {
        List<GarageEntity> allGarages = superAdminService.getAllGarages();
        return ResponseEntity.ok(allGarages);
    }
}
