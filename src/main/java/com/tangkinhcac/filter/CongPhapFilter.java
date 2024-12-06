package com.tangkinhcac.filter;

import com.tangkinhcac.model.DangNhap;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/cong-phap/chi-tiet",
        "/cong-phap/them",
        "/cong-phap/sua",
        "/cong-phap/xoa"
})
public class CongPhapFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        String uri = ((HttpServletRequest) request).getRequestURI();
        DangNhap dangNhap = (DangNhap) session.getAttribute("dangNhap");
        if (dangNhap == null) {
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
            Boolean isAdmin = dangNhap.getAdmin();
            if (isAdmin) {
                chain.doFilter(request, response);
            } else {
                if (uri.equals("/cong-phap/chi-tiet")) {
                    chain.doFilter(request, response);
                } else {
                    resp.setContentType("text/html");
                    resp.getWriter().write("<script type='text/javascript'>"
                            + "alert('Không có quyền');"
                            + "window.location.href = '/cong-phap/hien-thi';"
                            + "</script>");
                }
            }
        }
    }
}