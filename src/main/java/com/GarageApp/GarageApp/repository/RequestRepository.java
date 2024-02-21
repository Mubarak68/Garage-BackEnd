package com.GarageApp.GarageApp.repository;

import com.GarageApp.GarageApp.Entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<RequestEntity, Long> {

}
