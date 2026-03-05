package com.example.oceanviewreservation.dao.impl;

import com.example.oceanviewreservation.config.Db;
import com.example.oceanviewreservation.dao.RoomTypeDao;
import com.example.oceanviewreservation.model.RoomType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDaoImpl implements RoomTypeDao {

    @Override
    public List<RoomType> findAll() {
        String sql = "SELECT id, code, name, rate_per_night FROM room_types ORDER BY id";
        List<RoomType> list = new ArrayList<>();

        try (Connection con = Db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                RoomType rt = new RoomType(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getBigDecimal("rate_per_night")
                );
                list.add(rt);
            }
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Load room types failed", e);
        }
    }

    @Override
    public RoomType findByCode(String code) {
        String sql = "SELECT id, code, name, rate_per_night FROM room_types WHERE code = ?";
        try (Connection con = Db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;
                return new RoomType(
                        rs.getInt("id"),
                        rs.getString("code"),
                        rs.getString("name"),
                        rs.getBigDecimal("rate_per_night")
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Find room type failed", e);
        }
    }
}
