package com.GarageApp.GarageApp.service.superadmin;

import com.GarageApp.GarageApp.Entity.CategoryEntity;
import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.Entity.RoleEntity;
import com.GarageApp.GarageApp.bo.garage.CreateGarageRequest;
import com.GarageApp.GarageApp.repository.CategoryRepository;
import com.GarageApp.GarageApp.repository.GarageRepository;
import com.GarageApp.GarageApp.repository.RoleRepository;
import com.GarageApp.GarageApp.util.enums.Category;
import com.GarageApp.GarageApp.util.enums.Roles;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuperAdminServiceImpl implements SuperAdminService{

    private final GarageRepository garageRepository;
    private final CategoryRepository categoryRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    public SuperAdminServiceImpl(GarageRepository garageRepository, CategoryRepository categoryRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository) {
        this.garageRepository = garageRepository;
        this.categoryRepository = categoryRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public List<GarageEntity> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    public void addGarage(CreateGarageRequest createGarageRequest) {
        CategoryEntity category=categoryRepository.
                findByCategoryName(Category.valueOf(createGarageRequest.getCategory()));
        RoleEntity roleEntity= roleRepository.findRoleEntityByTitle(Roles.admin.name())
                .orElseThrow();
        GarageEntity garage = new GarageEntity();
        garage.setGarageName(createGarageRequest.getGarageName());
        garage.setLocation(createGarageRequest.getLocation());
        garage.setRating(createGarageRequest.getRating());
        garage.setCategoryEntity(category);
        garage.setSpecialIn(createGarageRequest.getSpecialIn());
        garage.setUsername(createGarageRequest.getUsername());
        garage.setPassword(bCryptPasswordEncoder.encode(createGarageRequest.getPassword()));
        garage.setRoles(roleEntity);
        garageRepository.save(garage);

    }


}
