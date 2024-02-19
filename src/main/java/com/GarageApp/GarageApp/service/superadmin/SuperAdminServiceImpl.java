package com.GarageApp.GarageApp.service.superadmin;

import com.GarageApp.GarageApp.Entity.CategoryEntity;
import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.bo.category.CreateCategoryRequest;
import com.GarageApp.GarageApp.bo.garage.CreateGarageRequest;
import com.GarageApp.GarageApp.repository.CategoryRepository;
import com.GarageApp.GarageApp.repository.GarageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminServiceImpl implements SuperAdminService{

    private final GarageRepository garageRepository;
    private final CategoryRepository categoryRepository;

    public SuperAdminServiceImpl(GarageRepository garageRepository, CategoryRepository categoryRepository) {
        this.garageRepository = garageRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<GarageEntity> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public void addGarage(CreateGarageRequest createGarageRequest) {
        GarageEntity garage = new GarageEntity();
        garage.setGarageName(createGarageRequest.getGarageName());
        garage.setLocation(createGarageRequest.getLocation());
        garage.setRating(createGarageRequest.getRating());
        garage.setSpecialIn(createGarageRequest.getSpecialIn());
        garageRepository.save(garage);

//
    }

    @Override
    public void addCategory(CreateCategoryRequest createCategoryRequest) {
        CategoryEntity category = new CategoryEntity();
        category.setCategoryName(createCategoryRequest.getCategoryName());
        categoryRepository.save(category);
    }
}
