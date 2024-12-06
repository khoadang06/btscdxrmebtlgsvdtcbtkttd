package com.tangkinhcac.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tangkinhcac.dto.CongPhapDTO;
import com.tangkinhcac.model.CongPhap;
import com.tangkinhcac.repository.CongPhapRepo;
import com.tangkinhcac.repository.LoaiCongPhapRepo;
import com.tangkinhcac.repository.PhamChatRepo;
import com.tangkinhcac.util.json.LocalDateTypeAdapter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

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
            int page = 0;
            if (request.getParameter("page") != null) {
                page = Integer.parseInt(request.getParameter("page"));
            }
            request.setAttribute("page", page);
            request.setAttribute("listPhamChat", phamChatRepo.getAllPhamChat());
            request.setAttribute("listLoaiCongPhap", loaiCongPhapRepo.getAllLoaiCongPhap());
            request.setAttribute("listCongPhap", congPhapRepo.getAllCongPhap());
            request.setAttribute("danhSachCongPhap", congPhapRepo.phanTrangCongPhap(page, 5));
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else if (uri.contains("chi-tiet")) {
            CongPhapDTO congPhap = new CongPhapRepo().getCongPhapDTOById(Integer.parseInt(request.getParameter("id")));
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).create();
            String congPhapJson = gson.toJson(congPhap);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(congPhapJson);
            out.flush();
        } else if (uri.contains("sua")) {
            String id = request.getParameter("id");
            request.setAttribute("listPhamChat", phamChatRepo.getAllPhamChat());
            request.setAttribute("listLoaiCongPhap", loaiCongPhapRepo.getAllLoaiCongPhap());
            request.setAttribute("congPhap", congPhapRepo.getCongPhapById(Integer.parseInt(id)));
            request.getRequestDispatcher("/WEB-INF/update.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("them")) {
            CongPhap congPhap = new CongPhap();
            congPhap.setTenCongPhap(request.getParameter("tenCongPhap"));
            congPhap.setMoTa(request.getParameter("moTa"));
            congPhap.setPhamChat(phamChatRepo.getPhamChatById(Integer.parseInt(request.getParameter("phamChat"))));
            congPhap.setNgayTao(LocalDate.parse(request.getParameter("ngayTao")));
            congPhap.setNgayCapNhat(LocalDate.parse(request.getParameter("ngayCapNhat")));
            congPhap.setLoaiCongPhap(loaiCongPhapRepo.getLoaiCongPhapById(Integer.parseInt(request.getParameter("tenLoaiCongPhap"))));
            congPhap.setThatTruyen(Boolean.parseBoolean(request.getParameter("thatTruyen")));
            congPhapRepo.add(congPhap);
            response.sendRedirect("/cong-phap/hien-thi");
        } else if (uri.contains("sua")) {
            CongPhap congPhap = new CongPhapRepo().getCongPhapById(Integer.parseInt(request.getParameter("id")));
            congPhap.setTenCongPhap(request.getParameter("tenCongPhap"));
            congPhap.setMoTa(request.getParameter("moTa"));
            congPhap.setPhamChat(phamChatRepo.getPhamChatById(Integer.parseInt(request.getParameter("phamChat"))));
            congPhap.setNgayTao(LocalDate.parse(request.getParameter("ngayTao")));
            congPhap.setNgayCapNhat(LocalDate.parse(request.getParameter("ngayCapNhat")));
            congPhap.setLoaiCongPhap(loaiCongPhapRepo.getLoaiCongPhapById(Integer.parseInt(request.getParameter("tenLoaiCongPhap"))));
            congPhap.setThatTruyen(Boolean.parseBoolean(request.getParameter("thatTruyen")));
            congPhapRepo.sua(congPhap);
            response.sendRedirect("/cong-phap/hien-thi");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("xoa")) {
            CongPhap congPhap = congPhapRepo.getCongPhapById(Integer.parseInt(request.getParameter("id")));
            congPhapRepo.xoa(congPhap);
            response.sendRedirect("/cong-phap/hien-thi");
        }
    }
}