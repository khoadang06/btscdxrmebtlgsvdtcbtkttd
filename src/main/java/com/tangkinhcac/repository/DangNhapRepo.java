package com.tangkinhcac.repository;

import com.tangkinhcac.model.DangNhap;
import com.tangkinhcac.util.HibernateConfig;
import org.hibernate.Session;

public class DangNhapRepo {
    private Session session;

    public DangNhapRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public DangNhap getByNameAndPass(String username, String password) {
        return session.createQuery("FROM DangNhap WHERE tenDangNhap = :username AND matKhau = :password", DangNhap.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
    }
}
