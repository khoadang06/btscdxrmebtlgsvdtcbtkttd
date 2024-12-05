package com.tangkinhcac.controller;

import com.tangkinhcac.model.CongPhap;
import com.tangkinhcac.model.LoaiCongPhap;
import com.tangkinhcac.model.PhamChat;
import com.tangkinhcac.repository.CongPhapRepo;
import com.tangkinhcac.repository.LoaiCongPhapRepo;
import com.tangkinhcac.repository.PhamChatRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet(name = "CongPhapServlet", value = {
        "/cong-phap/hien-thi",
        "/cong-phap/chi-tiet",
        "/cong-phap/them",
        "/cong-phap/sua",
        "/cong-phap/xoa"
})
public class CongPhapServlet extends HttpServlet {
    CongPhapRepo congPhapRepo = new CongPhapRepo();
    PhamChatRepo phamChatRepo = new PhamChatRepo();
    LoaiCongPhapRepo loaiCongPhapRepo = new LoaiCongPhapRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi")) {
            request.setAttribute("listPhamChat", phamChatRepo.getAllPhamChat());
            request.setAttribute("listLoaiCongPhap", loaiCongPhapRepo.getAllLoaiCongPhap());
            request.setAttribute("listCongPhap", congPhapRepo.getAllCongPhap());
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (uri.contains("chi-tiet")) {
            request.setAttribute("congPhap", congPhapRepo.getCongPhapById(Integer.parseInt(request.getParameter("id"))));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("them")) {
            String tenCongPhap = request.getParameter("tenCongPhap");
            String moTa = request.getParameter("moTa");
            PhamChat phamChat = phamChatRepo.getPhamChatById(Integer.parseInt(request.getParameter("phamChat")));
            LocalDate ngayTao = LocalDate.parse(request.getParameter("ngayTao"));
            LocalDate ngayCapNhat = LocalDate.parse(request.getParameter("ngayCapNhat"));
            LoaiCongPhap loaiCongPhap = loaiCongPhapRepo.getLoaiCongPhapById(Integer.parseInt(request.getParameter("loaiCongPhap")));
            Boolean thatTruyen = Boolean.parseBoolean(request.getParameter("thatTruyen"));
            CongPhap congPhap = new CongPhap();
            congPhap.setTenCongPhap(tenCongPhap);
            congPhap.setMoTa(moTa);
            congPhap.setPhamChat(phamChat);
            congPhap.setNgayTao(ngayTao);
            congPhap.setNgayCapNhat(ngayCapNhat);
            congPhap.setLoaiCongPhap(loaiCongPhap);
            congPhap.setThatTruyen(thatTruyen);
            congPhapRepo.add(congPhap);
            response.sendRedirect("/cong-phap/hien-thi");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}