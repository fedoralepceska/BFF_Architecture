package com.example.bff3.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    DOCTOR,
    PATIENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
