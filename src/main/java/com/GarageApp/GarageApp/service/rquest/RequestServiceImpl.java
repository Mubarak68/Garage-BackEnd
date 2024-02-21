package com.GarageApp.GarageApp.service.rquest;

import com.GarageApp.GarageApp.Entity.RequestEntity;
import com.GarageApp.GarageApp.repository.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RequestServiceImpl implements RequestService{

    private final RequestRepository requestRepository;

    public RequestServiceImpl(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Override
    public List<RequestEntity> getAllRequest() {
        return requestRepository.findAll();
    }

    @Override
    public RequestEntity getRequestById(Long requestId) {
        return requestRepository.findById(requestId)
                .orElseThrow();
    }
}
