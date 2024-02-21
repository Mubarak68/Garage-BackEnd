package com.GarageApp.GarageApp.service.rquest;

import com.GarageApp.GarageApp.Entity.RequestEntity;

import java.util.List;

public interface RequestService {

    List<RequestEntity> getAllRequest();

    RequestEntity getRequestById(Long requestId);
}
