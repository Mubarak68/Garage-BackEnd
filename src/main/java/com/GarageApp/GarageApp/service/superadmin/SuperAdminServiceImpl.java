package com.GarageApp.GarageApp.service.superadmin;

import com.GarageApp.GarageApp.Entity.CategoryEntity;
import com.GarageApp.GarageApp.Entity.GarageEntity;
import com.GarageApp.GarageApp.Entity.RoleEntity;
import com.GarageApp.GarageApp.Entity.UserEntity;
import com.GarageApp.GarageApp.bo.garage.CreateGarageRequest;
import com.GarageApp.GarageApp.repository.CategoryRepository;
import com.GarageApp.GarageApp.repository.GarageRepository;
import com.GarageApp.GarageApp.repository.RoleRepository;
import com.GarageApp.GarageApp.repository.UserRepository;
import com.GarageApp.GarageApp.util.enums.Category;
import com.GarageApp.GarageApp.util.enums.Roles;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SuperAdminServiceImpl implements SuperAdminService{

    private final GarageRepository garageRepository;
    private final CategoryRepository categoryRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    public SuperAdminServiceImpl(GarageRepository garageRepository, CategoryRepository categoryRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository, UserRepository userRepository) {
        this.garageRepository = garageRepository;
        this.categoryRepository = categoryRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<GarageEntity> getAllGarages() {
        return garageRepository.findAll();
    }

    @Override
    @Transactional
    public void addGarage(CreateGarageRequest createGarageRequest) {
        CategoryEntity category=categoryRepository.
                findByCategoryName(Category.valueOf(createGarageRequest.getCategory()));
        RoleEntity roleEntity= roleRepository.findRoleEntityByTitle(Roles.admin.name())
                .orElseThrow();
        UserEntity userEntity=new UserEntity();
        userEntity.setUsername(createGarageRequest.getUsername());
        userEntity.setEmail(createGarageRequest.getUsername());
        userEntity.setRoles(roleEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(createGarageRequest.getPassword()));
        GarageEntity garage = new GarageEntity();
        garage.setGarageName(createGarageRequest.getGarageName());
        garage.setLocation(createGarageRequest.getLocation());
        garage.setRating(createGarageRequest.getRating());
        garage.setCategoryEntity(category);
        garage.setSpecialIn(createGarageRequest.getSpecialIn());
        garage.setUserEntity(userEntity);

        garageRepository.save(garage);
        userRepository.save(userEntity);

    }


}
