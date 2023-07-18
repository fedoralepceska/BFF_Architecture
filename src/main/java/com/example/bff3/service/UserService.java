package com.example.bff3.service;

import com.example.bff3.model.User;
import com.example.bff3.model.UserRole;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User register(String username, String password, String repeatPassword, String name, String surname, UserRole role);
}

