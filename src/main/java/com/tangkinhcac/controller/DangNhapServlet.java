package com.tangkinhcac.controller;

import com.tangkinhcac.Service.DangNhapService;
import com.tangkinhcac.model.DangNhap;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class DangNhapServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        DangNhap dangNhap = new DangNhapService().getByNameAndPass(username, password);
        if (dangNhap != null) {
            HttpSession session = request.getSession();
            session.setAttribute("dangNhap", dangNhap);
            response.sendRedirect("/cong-phap/hien-thi");
        } else {
            request.setAttribute("error", "Sai tên đăng nhập hoặc mật khẩu");
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }
}