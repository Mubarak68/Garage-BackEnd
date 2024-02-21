package com.GarageApp.GarageApp.service.admin;

import com.GarageApp.GarageApp.bo.user.UpdateStatusRequest;

public interface AdminService {

    void updateStatusRequest(Long requestId, UpdateStatusRequest updateStatusRequest);

}
