package com.example.oceanviewreservation.dao.impl;

import com.example.oceanviewreservation.config.Db;
import com.example.oceanviewreservation.dao.ReservationDao;
import com.example.oceanviewreservation.model.Reservation;

import java.sql.*;
import java.time.LocalDate;

public class ReservationDaoImpl implements ReservationDao {

    @Override
    public boolean existsReservationNo(String reservationNo) {
        String sql = "SELECT 1 FROM reservations WHERE reservation_no = ?";
        try (Connection con = Db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, reservationNo);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            throw new RuntimeException("Check reservation exists failed", e);
        }
    }

    @Override
    public void create(Reservation r) {
        String sql = "INSERT INTO reservations(reservation_no, guest_name, address, contact_number, room_type_code, check_in, check_out) " +
                "VALUES(?,?,?,?,?,?,?)";
        try (Connection con = Db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getReservationNo());
            ps.setString(2, r.getGuestName());
            ps.setString(3, r.getAddress());
            ps.setString(4, r.getContactNumber());
            ps.setString(5, r.getRoomTypeCode());
            ps.setDate(6, Date.valueOf(r.getCheckIn()));
            ps.setDate(7, Date.valueOf(r.getCheckOut()));
            ps.executeUpdate();

        } catch (SQLIntegrityConstraintViolationException dup) {
            throw new RuntimeException("Reservation number already exists.");
        } catch (Exception e) {
            throw new RuntimeException("Create reservation failed", e);
        }
    }
    @Override
    public void deleteByReservationNo(String reservationNo) {

        String sql = "DELETE FROM reservations WHERE reservation_no=?";

        try (Connection con = Db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reservationNo);
            ps.executeUpdate();

        } catch (Exception e) {
            throw new RuntimeException("Delete reservation failed", e);
        }
    }

    @Override
    public Reservation findByReservationNo(String reservationNo) {
        String sql = "SELECT id, reservation_no, guest_name, address, contact_number, room_type_code, check_in, check_out " +
                "FROM reservations WHERE reservation_no = ?";
        try (Connection con = Db.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reservationNo);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) return null;

                LocalDate ci = rs.getDate("check_in").toLocalDate();
                LocalDate co = rs.getDate("check_out").toLocalDate();

                return new Reservation(
                        rs.getInt("id"),
                        rs.getString("reservation_no"),
                        rs.getString("guest_name"),
                        rs.getString("address"),
                        rs.getString("contact_number"),
                        rs.getString("room_type_code"),
                        ci, co
                );
            }
        } catch (Exception e) {
            throw new RuntimeException("Find reservation failed", e);
        }
    }
}
