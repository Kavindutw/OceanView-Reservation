package com.example.oceanviewreservation.service;

import com.example.oceanviewreservation.model.User;

public interface AuthService {
    User login(String username, String password);
}
