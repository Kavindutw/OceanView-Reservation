package com.example.oceanviewreservation.dao.impl;

import com.example.oceanviewreservation.config.Db;
import com.example.oceanviewreservation.dao.UserDao;
import com.example.oceanviewreservation.model.User;
import com.example.oceanviewreservation.util.PasswordUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {

    @Override
    public User findByUsernameAndPassword(String username, String passwordPlain) {
        String sql = "SELECT id, username, password_hash, role FROM users WHERE username = ?";
        try (Connection con = Db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                String hash = rs.getString("password_hash");
                if (!PasswordUtil.verify(passwordPlain, hash)) return null;

                return new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("role")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("User login failed", e);
        }
    }
}
