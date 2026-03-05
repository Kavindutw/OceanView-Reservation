package com.example.oceanviewreservation.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }
}
