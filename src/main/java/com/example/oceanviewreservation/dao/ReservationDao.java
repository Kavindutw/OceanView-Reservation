package com.example.oceanviewreservation.dao;

import com.example.oceanviewreservation.model.Reservation;

public interface ReservationDao {
    boolean existsReservationNo(String reservationNo);
    void create(Reservation r);
    Reservation findByReservationNo(String reservationNo);
}
