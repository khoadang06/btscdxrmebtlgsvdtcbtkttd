package com.tangkinhcac.repository;

import com.tangkinhcac.dto.CongPhapDTO;
import com.tangkinhcac.model.CongPhap;
import com.tangkinhcac.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class CongPhapRepo {
    private Session session;

    public CongPhapRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<CongPhapDTO> getAllCongPhap() {
        return session.createQuery("SELECT new com.tangkinhcac.dto.CongPhapDTO(cp.id, cp.tenCongPhap, cp.moTa, pc.tenPhamChat, cp.ngayTao, cp.ngayCapNhat, lcp.tenLoaiCongPhap, cp.thatTruyen)" +
                "FROM CongPhap cp JOIN cp.loaiCongPhap lcp JOIN cp.phamChat pc", CongPhapDTO.class).getResultList();
    }

    public CongPhapDTO getCongPhapById(Integer id) {
        return session.createQuery("SELECT new com.tangkinhcac.dto.CongPhapDTO(cp.id, cp.tenCongPhap, cp.moTa, pc.tenPhamChat, cp.ngayTao, cp.ngayCapNhat, lcp.tenLoaiCongPhap, cp.thatTruyen)" +
                "FROM CongPhap cp JOIN cp.loaiCongPhap lcp JOIN cp.phamChat pc " +
                "WHERE cp.id = :id", CongPhapDTO.class).setParameter("id", id).getSingleResult();
    }

    public List<CongPhapDTO> getCongPhapByName(String name) {
        return session.createQuery("SELECT new com.tangkinhcac.dto.CongPhapDTO(cp.id, cp.tenCongPhap, cp.moTa, pc.tenPhamChat, cp.ngayTao, cp.ngayCapNhat, lcp.tenLoaiCongPhap, cp.thatTruyen)" +
                "FROM CongPhap cp JOIN cp.loaiCongPhap lcp JOIN cp.phamChat pc " +
                "WHERE cp.tenCongPhap = :name", CongPhapDTO.class).setParameter("name", name).getResultList();
    }

    public void add(CongPhap congPhap) {
        try {
            session.beginTransaction();
            session.persist(congPhap);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void update(CongPhap congPhap) {
        try {
            session.beginTransaction();
            session.merge(congPhap);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
