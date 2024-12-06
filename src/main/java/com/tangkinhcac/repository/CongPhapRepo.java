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
        return session.createQuery("SELECT new com.tangkinhcac.dto.CongPhapDTO(cp.id, cp.tenCongPhap, cp.moTa, pc.tenPhamChat, pc.id ,cp.ngayTao, cp.ngayCapNhat, lcp.tenLoaiCongPhap, lcp.id, cp.thatTruyen)" +
                "FROM CongPhap cp JOIN cp.loaiCongPhap lcp JOIN cp.phamChat pc", CongPhapDTO.class).getResultList();
    }

    public CongPhapDTO getCongPhapDTOById(Integer id) {
        return session.createQuery("SELECT new com.tangkinhcac.dto.CongPhapDTO(cp.id, cp.tenCongPhap, cp.moTa, pc.tenPhamChat, pc.id ,cp.ngayTao, cp.ngayCapNhat, lcp.tenLoaiCongPhap, lcp.id, cp.thatTruyen)" +
                "FROM CongPhap cp JOIN cp.loaiCongPhap lcp JOIN cp.phamChat pc " +
                "WHERE cp.id = :id", CongPhapDTO.class).setParameter("id", id).getSingleResult();
    }

    public List<CongPhapDTO> getCongPhapByName(String name) {
        return session.createQuery("SELECT new com.tangkinhcac.dto.CongPhapDTO(cp.id, cp.tenCongPhap, cp.moTa, pc.tenPhamChat, pc.id ,cp.ngayTao, cp.ngayCapNhat, lcp.tenLoaiCongPhap, lcp.id, cp.thatTruyen)" +
                "FROM CongPhap cp JOIN cp.loaiCongPhap lcp JOIN cp.phamChat pc " +
                "WHERE cp.tenCongPhap = :name", CongPhapDTO.class).setParameter("name", name).getResultList();
    }

    public CongPhap getCongPhapById(Integer id) {
        return session.createQuery("FROM CongPhap WHERE id = :id", CongPhap.class).setParameter("id", id).getSingleResult();
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

    public void sua(CongPhap congPhap) {
        try {
            session.beginTransaction();
            session.merge(congPhap);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public void xoa(CongPhap congPhap) {
        try {
            session.beginTransaction();
            session.remove(congPhap);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    public List<CongPhapDTO> phanTrangCongPhap(int page, int pageSize) {
        return session.createQuery("SELECT new com.tangkinhcac.dto.CongPhapDTO(cp.id, cp.tenCongPhap, cp.moTa, pc.tenPhamChat, pc.id ,cp.ngayTao, cp.ngayCapNhat, lcp.tenLoaiCongPhap, lcp.id, cp.thatTruyen)" +
                "FROM CongPhap cp JOIN cp.loaiCongPhap lcp JOIN cp.phamChat pc", CongPhapDTO.class).setFirstResult(page * pageSize).setMaxResults(pageSize).getResultList();
    }
}
