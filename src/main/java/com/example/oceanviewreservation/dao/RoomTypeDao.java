package com.example.oceanviewreservation.dao;

import com.example.oceanviewreservation.model.RoomType;
import java.util.List;

public interface RoomTypeDao {
    List<RoomType> findAll();
    RoomType findByCode(String code);
}
