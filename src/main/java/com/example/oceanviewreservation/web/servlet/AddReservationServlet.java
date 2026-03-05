package com.example.oceanviewreservation.web.servlet;

import com.example.oceanviewreservation.dao.RoomTypeDao;
import com.example.oceanviewreservation.dao.impl.RoomTypeDaoImpl;
import com.example.oceanviewreservation.model.Reservation;
import com.example.oceanviewreservation.service.ReservationService;
import com.example.oceanviewreservation.service.impl.ReservationServiceImpl;
import com.example.oceanviewreservation.util.ValidationUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/reservation/add")
public class AddReservationServlet extends HttpServlet {

    private final ReservationService reservationService = new ReservationServiceImpl();
    private final RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("roomTypes", roomTypeDao.findAll());
        req.getRequestDispatcher("/reservation-add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {

        List<String> errors = new ArrayList<>();

        String reservationNo = req.getParameter("reservationNo");
        String guestName = req.getParameter("guestName");
        String address = req.getParameter("address");
        String contact = req.getParameter("contactNumber");
        String roomTypeCode = req.getParameter("roomTypeCode");
        String checkInStr = req.getParameter("checkIn");
        String checkOutStr = req.getParameter("checkOut");

        errors.addAll(ValidationUtil.validateReservationNo(reservationNo));
        errors.addAll(ValidationUtil.validateGuestName(guestName));
        errors.addAll(ValidationUtil.validateAddress(address));
        errors.addAll(ValidationUtil.validateContact(contact));

        LocalDate checkIn = null;
        LocalDate checkOut = null;

        try { checkIn = LocalDate.parse(checkInStr); } catch (Exception e) { errors.add("Invalid check-in date."); }
        try { checkOut = LocalDate.parse(checkOutStr); } catch (Exception e) { errors.add("Invalid check-out date."); }

        if (roomTypeCode == null || roomTypeCode.trim().isEmpty()) errors.add("Room type is required.");
        if (checkIn != null && checkOut != null && !checkOut.isAfter(checkIn)) errors.add("Check-out must be after check-in.");

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            req.setAttribute("roomTypes", roomTypeDao.findAll());
            req.getRequestDispatcher("/reservation-add.jsp").forward(req, resp);
            return;
        }

        try {
            Reservation r = new Reservation();
            r.setReservationNo(reservationNo.trim());
            r.setGuestName(guestName.trim());
            r.setAddress(address.trim());
            r.setContactNumber(contact.trim());
            r.setRoomTypeCode(roomTypeCode.trim());
            r.setCheckIn(checkIn);
            r.setCheckOut(checkOut);

            reservationService.addReservation(r);

            resp.sendRedirect(req.getContextPath() + "/reservation/view?reservationNo=" + reservationNo.trim());
        } catch (Exception ex) {
            errors.add(ex.getMessage());
            req.setAttribute("errors", errors);
            req.setAttribute("roomTypes", roomTypeDao.findAll());
            req.getRequestDispatcher("/reservation-add.jsp").forward(req, resp);
        }
    }
}
