package com.tangkinhcac.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DangXuatServlet", value = "/logout")
public class DangXuatServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Không tạo session mới nếu không có
        if (session != null) {
            session.invalidate(); // Hủy session hiện tại
        }
        response.sendRedirect("/login");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
    }
}