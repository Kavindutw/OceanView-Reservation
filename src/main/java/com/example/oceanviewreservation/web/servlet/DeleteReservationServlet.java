package com.example.oceanviewreservation.web.servlet;

import com.example.oceanviewreservation.service.ReservationService;
import com.example.oceanviewreservation.service.impl.ReservationServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/reservation/delete")
public class DeleteReservationServlet extends HttpServlet {

    private final ReservationService reservationService =
            new ReservationServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws IOException {

        String reservationNo = req.getParameter("reservationNo");

        try {
            reservationService.deleteReservation(reservationNo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}
