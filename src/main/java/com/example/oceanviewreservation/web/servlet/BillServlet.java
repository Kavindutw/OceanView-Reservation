package com.example.oceanviewreservation.web.servlet;

import com.example.oceanviewreservation.model.Reservation;
import com.example.oceanviewreservation.service.BillingService;
import com.example.oceanviewreservation.service.ReservationService;
import com.example.oceanviewreservation.service.impl.BillingServiceImpl;
import com.example.oceanviewreservation.service.impl.ReservationServiceImpl;
import com.example.oceanviewreservation.util.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.math.BigDecimal;

@WebServlet("/bill")
public class BillServlet extends HttpServlet {
    private final BillingService billingService = new BillingServiceImpl();
    private final ReservationService reservationService = new ReservationServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/bill.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {

        String reservationNo = req.getParameter("reservationNo");

        try {
            Reservation r = reservationService.getByReservationNo(reservationNo);
            if (r == null) throw new RuntimeException("Reservation not found.");

            long nights = DateUtil.nights(r.getCheckIn(), r.getCheckOut());
            BigDecimal total = billingService.calculateTotal(reservationNo);

            req.setAttribute("reservation", r);
            req.setAttribute("nights", nights);
            req.setAttribute("total", total);

        } catch (Exception e) {
            req.setAttribute("error", e.getMessage());
        }

        req.getRequestDispatcher("/bill.jsp").forward(req, resp);
    }
}
