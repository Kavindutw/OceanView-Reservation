package com.example.oceanviewreservation.service.impl;

import com.example.oceanviewreservation.dao.UserDao;
import com.example.oceanviewreservation.dao.impl.UserDaoImpl;
import com.example.oceanviewreservation.model.User;
import com.example.oceanviewreservation.service.AuthService;

public class AuthServiceImpl implements AuthService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public User login(String username, String password) {
        return userDao.findByUsernameAndPassword(username, password);
    }
}
