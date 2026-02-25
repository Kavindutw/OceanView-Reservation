package com.example.oceanviewreservation.service.impl;

import com.example.oceanviewreservation.dao.ReservationDao;
import com.example.oceanviewreservation.dao.impl.ReservationDaoImpl;
import com.example.oceanviewreservation.model.Reservation;
import com.example.oceanviewreservation.service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
    private final ReservationDao reservationDao = new ReservationDaoImpl();

    @Override
    public void addReservation(Reservation r) {
        if (reservationDao.existsReservationNo(r.getReservationNo())) {
            throw new RuntimeException("Reservation number already exists. Please use a unique number.");
        }
        if (!r.getCheckOut().isAfter(r.getCheckIn())) {
            throw new RuntimeException("Check-out date must be after check-in date.");
        }
        reservationDao.create(r);
    }

    @Override
    public Reservation getByReservationNo(String reservationNo) {
        return reservationDao.findByReservationNo(reservationNo);
    }
}
