package com.jpa.example.Dao;

import com.jpa.example.models.Client;

import javax.persistence.EntityManager;
import java.util.List;

public class ClientDaoImp implements IClient{
    @Override
    public boolean save(Client o) {
        EntityManager em = PersistanceDao.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            em.getTransaction().rollback();

            em.close();
            return false;
        }
    }

    @Override
    public boolean delete(Client o) {
        EntityManager em = PersistanceDao.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            em.close();
            return false;
        }
    }

    @Override
    public boolean update(Client o) {
        EntityManager em = PersistanceDao.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
            em.close();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            System.err.println(e.getMessage());
            em.close();
            return false;
        }
    }

    @Override
    public Client findById(Long s) {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT c FROM Client c WHERE c.id=:id", Client.class)
                .setParameter("id", s)
                .getSingleResult();
    }

    @Override
    public List<Client> findAll() {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT c FROM Client c", Client.class).getResultList();
    }
}
