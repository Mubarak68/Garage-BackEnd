package com.GarageApp.GarageApp.service.auth;

import com.GarageApp.GarageApp.Entity.EndUserEntity;
import com.GarageApp.GarageApp.Entity.RoleEntity;
import com.GarageApp.GarageApp.Entity.UserEntity;
import com.GarageApp.GarageApp.bo.AuthinticationResponse;
import com.GarageApp.GarageApp.bo.CreateLoginRequest;
import com.GarageApp.GarageApp.bo.CreateSignupRequest;

import com.GarageApp.GarageApp.bo.CustomUserDetails;
import com.GarageApp.GarageApp.config.JWTUtil;
import com.GarageApp.GarageApp.excption.UserNotFoundException;
import com.GarageApp.GarageApp.repository.EndUserRepository;
import com.GarageApp.GarageApp.repository.RoleRepository;
import com.GarageApp.GarageApp.repository.UserRepository;
import com.GarageApp.GarageApp.util.enums.Roles;
import com.GarageApp.GarageApp.util.enums.VehicleType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AuthServiceImpl implements AuthService{

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailsService;
    private final JWTUtil jwtUtil;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final UserRepository userRepository;

    private final EndUserRepository endUserRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailsService, JWTUtil jwtUtil, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, EndUserRepository endUserRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.endUserRepository = endUserRepository;
    }


    @Override
    @Transactional
    public void signup(CreateSignupRequest createSignupRequest) {
        RoleEntity roleEntity= roleRepository.findRoleEntityByTitle(Roles.user.name())
                .orElseThrow();
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(createSignupRequest.getUsername());
        userEntity.setEmail(createSignupRequest.getEmail());
        userEntity.setRoles(roleEntity);
        userEntity.setPassword(bCryptPasswordEncoder.encode(createSignupRequest.getPassword()));

        EndUserEntity endUserEntity = new EndUserEntity();
        endUserEntity.setUserEntity(userEntity);
        endUserEntity.setVehicleModel(createSignupRequest.getVehicleModel());
        endUserEntity.setVehicleType(VehicleType.valueOf(createSignupRequest.getVehicleType()));
        endUserEntity.setVehicleYear(createSignupRequest.getVehicleYear());

        userRepository.save(userEntity);
        endUserRepository.save(endUserEntity);
    }



    @Override
    public AuthinticationResponse login(CreateLoginRequest createLoginRequest) {
        if (createLoginRequest.getPassword() == null || createLoginRequest.getUsername() == null){
            throw new NullPointerException();
        }
        String username = createLoginRequest.getUsername().toLowerCase();
        String password = createLoginRequest.getPassword();

        authentication(username, password);

        CustomUserDetails userDetails = userDetailsService.loadUserByUsername(username);

        String accessToken = jwtUtil.generateToken(userDetails);

        AuthinticationResponse response = new AuthinticationResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer " + accessToken);
        return response;
    }




    private void authentication(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));


        } catch (AuthenticationServiceException e) {
            throw new UserNotFoundException("Incorrect username");
        }
    }


}

