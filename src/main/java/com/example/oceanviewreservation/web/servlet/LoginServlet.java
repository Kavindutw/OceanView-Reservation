package com.example.oceanviewreservation.web.servlet;

import com.example.oceanviewreservation.config.AppConfig;
import com.example.oceanviewreservation.model.User;
import com.example.oceanviewreservation.service.AuthService;
import com.example.oceanviewreservation.service.impl.AuthServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final AuthService authService = new AuthServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = authService.login(username, password);
        if (user == null) {
            req.setAttribute("error", "Invalid username or password.");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
            return;
        }

        req.getSession().setAttribute(AppConfig.SESSION_USER, user);
        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}
