package com.GarageApp.GarageApp.service.admin;

import com.GarageApp.GarageApp.Entity.RequestEntity;
import com.GarageApp.GarageApp.bo.user.UpdateStatusRequest;
import com.GarageApp.GarageApp.repository.RequestRepository;
import com.GarageApp.GarageApp.util.enums.Request;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{

    private final RequestRepository requestRepository;

    public AdminServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public void updateStatusRequest(Long requestId, UpdateStatusRequest updateStatusRequest) {
        RequestEntity request = requestRepository.findById(requestId).orElseThrow();
        request.setRequestStatus(Request.valueOf(updateStatusRequest.getRequestStatus()));
        requestRepository.save(request);
    }
}
