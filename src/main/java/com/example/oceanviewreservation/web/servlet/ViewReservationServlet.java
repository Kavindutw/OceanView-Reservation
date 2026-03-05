package com.example.oceanviewreservation.web.servlet;

import com.example.oceanviewreservation.dao.RoomTypeDao;
import com.example.oceanviewreservation.dao.impl.RoomTypeDaoImpl;
import com.example.oceanviewreservation.model.Reservation;
import com.example.oceanviewreservation.model.RoomType;
import com.example.oceanviewreservation.service.ReservationService;
import com.example.oceanviewreservation.service.impl.ReservationServiceImpl;
import com.example.oceanviewreservation.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/reservation/view")
public class ViewReservationServlet extends HttpServlet {

    private final ReservationService reservationService = new ReservationServiceImpl();
    private final RoomTypeDao roomTypeDao = new RoomTypeDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {

        String reservationNo = req.getParameter("reservationNo");
        if (reservationNo == null || reservationNo.trim().isEmpty()) {
            req.setAttribute("error", "Please enter a reservation number.");
            req.getRequestDispatcher("/reservation-view.jsp").forward(req, resp);
            return;
        }

        Reservation r = reservationService.getByReservationNo(reservationNo.trim());
        if (r == null) {
            req.setAttribute("error", "Reservation not found for number: " + reservationNo);
            req.getRequestDispatcher("/reservation-view.jsp").forward(req, resp);
            return;
        }

        RoomType rt = roomTypeDao.findByCode(r.getRoomTypeCode());
        long nights = DateUtil.nights(r.getCheckIn(), r.getCheckOut());

        req.setAttribute("reservation", r);
        req.setAttribute("roomType", rt);
        req.setAttribute("nights", nights);

        req.getRequestDispatcher("/reservation-view.jsp").forward(req, resp);
    }
}
