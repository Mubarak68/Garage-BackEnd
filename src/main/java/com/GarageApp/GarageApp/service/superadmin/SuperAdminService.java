package com.GarageApp.GarageApp.service.superadmin;

import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.bo.garage.CreateGarageRequest;

import java.util.List;

public interface SuperAdminService {
    List<GarageEntity> getAllGarages();
    void addGarage(CreateGarageRequest createGarageRequest);
}
