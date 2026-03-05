package com.example.oceanviewreservation.dao;

import com.example.oceanviewreservation.model.User;

public interface UserDao {
    User findByUsernameAndPassword(String username, String passwordPlain);
}
