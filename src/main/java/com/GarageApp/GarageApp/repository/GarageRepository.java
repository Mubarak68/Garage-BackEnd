package com.GarageApp.GarageApp.repository;

import com.GarageApp.GarageApp.Entity.GarageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarageRepository extends JpaRepository<GarageEntity,Long> {

}
