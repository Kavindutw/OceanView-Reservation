package com.example.oceanviewreservation.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/help")
public class HelpServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/help.jsp").forward(req, resp);
    }
}
