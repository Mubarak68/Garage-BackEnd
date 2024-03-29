package com.GarageApp.GarageApp.Entity;


import com.GarageApp.GarageApp.util.enums.Roles;
import com.GarageApp.GarageApp.util.enums.VehicleType;

import javax.persistence.*;

@Entity
@Table(name = "garage_users")
public class UserEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String username;


    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "password",nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public RoleEntity getRoles() {
        return roles;
    }

    public void setRoles(RoleEntity roles) {
        this.roles = roles;
    }

}
