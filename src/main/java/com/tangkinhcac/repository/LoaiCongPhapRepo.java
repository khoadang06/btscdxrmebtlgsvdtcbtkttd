package com.tangkinhcac.repository;

import com.tangkinhcac.model.LoaiCongPhap;
import com.tangkinhcac.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class LoaiCongPhapRepo {
    private Session session;

    public LoaiCongPhapRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<LoaiCongPhap> getAllLoaiCongPhap() {
        return session.createQuery("FROM LoaiCongPhap", LoaiCongPhap.class).getResultList();
    }

    public LoaiCongPhap getLoaiCongPhapById(Integer id) {
        return session.createQuery("FROM LoaiCongPhap WHERE id = :id", LoaiCongPhap.class).setParameter("id", id).getSingleResult();
    }
}
