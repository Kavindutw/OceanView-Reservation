package com.example.oceanviewreservation.service;

import com.example.oceanviewreservation.model.Reservation;

public interface ReservationService {
    void addReservation(Reservation r);
    Reservation getByReservationNo(String reservationNo);
}
