package com.example.bff3.service;

import com.example.bff3.model.User;

public interface AuthService {

    User login(String username, String password);
}
