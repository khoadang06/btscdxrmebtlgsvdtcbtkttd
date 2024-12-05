package com.tangkinhcac.repository;

import com.tangkinhcac.model.PhamChat;
import com.tangkinhcac.util.HibernateConfig;
import org.hibernate.Session;

import java.util.List;

public class PhamChatRepo {
    private Session session;

    public PhamChatRepo() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<PhamChat> getAllPhamChat() {
        return session.createQuery("FROM PhamChat", PhamChat.class).getResultList();
    }

    public PhamChat getPhamChatById(Integer id) {
        return session.createQuery("FROM PhamChat WHERE id = :id", PhamChat.class).setParameter("id", id).getSingleResult();
    }
}
