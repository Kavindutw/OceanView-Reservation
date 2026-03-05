package com.example.oceanviewreservation.service.impl;

import com.example.oceanviewreservation.dao.ReservationDao;
import com.example.oceanviewreservation.dao.RoomTypeDao;
import com.example.oceanviewreservation.dao.impl.ReservationDaoImpl;
import com.example.oceanviewreservation.dao.impl.RoomTypeDaoImpl;
import com.example.oceanviewreservation.model.Reservation;
import com.example.oceanviewreservation.model.RoomType;
import com.example.oceanviewreservation.service.BillingService;
import com.example.oceanviewreservation.util.DateUtil;

import java.math.BigDecimal;

public class BillingServiceImpl implements BillingService {
    private final ReservationDao reservationDao = new ReservationDaoImpl();
    private final RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();

    @Override
    public BigDecimal calculateTotal(String reservationNo) {
        Reservation r = reservationDao.findByReservationNo(reservationNo);
        if (r == null) throw new RuntimeException("Reservation not found.");

        RoomType rt = roomTypeDao.findByCode(r.getRoomTypeCode());
        if (rt == null) throw new RuntimeException("Room type not found.");

        long nights = DateUtil.nights(r.getCheckIn(), r.getCheckOut());
        if (nights <= 0) throw new RuntimeException("Invalid date range.");

        return rt.getRatePerNight().multiply(BigDecimal.valueOf(nights));
    }
}
