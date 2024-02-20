package com.GarageApp.GarageApp.service.auth;

import com.GarageApp.GarageApp.bo.CustomUserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserDetailUtil {
    public static CustomUserDetails userDetails(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (CustomUserDetails) authentication.getPrincipal();
    }
}
