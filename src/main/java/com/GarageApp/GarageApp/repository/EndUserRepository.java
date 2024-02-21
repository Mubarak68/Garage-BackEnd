package com.GarageApp.GarageApp.repository;

import com.GarageApp.GarageApp.Entity.EndUserEntity;
import com.GarageApp.GarageApp.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EndUserRepository extends JpaRepository<EndUserEntity, Long> {

    //@Query("SELECT a from #{#entityName} a WHERE userEntity = :userId")
    EndUserEntity findByUserEntity(UserEntity userId);
}
