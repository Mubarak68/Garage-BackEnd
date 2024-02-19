package com.GarageApp.GarageApp.service.ssadmin;

import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminServiceImpl implements SuperAdminService{

    private final GarageRepository garageRepository;

    public SuperAdminServiceImpl(GarageRepository garageRepository) {
        this.garageRepository = garageRepository;
    }

    @Override
    public List<GarageEntity> getAllGarages() {
        return garageRepository.findAll();
    }
}
