package com.jpa.example.Dao;

import com.jpa.example.models.Client;
import com.jpa.example.models.Commande;

import javax.persistence.EntityManager;
import java.util.List;

public class CommandeDaoImp implements ICommande{
    @Override
    public boolean save(Commande o) {
        EntityManager em = PersistanceDao.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
            em.close();
            return true;
        }catch(Exception e){
            System.err.println(e.getMessage());
            em.getTransaction().rollback();
            em.close();
            return false;
        }

    }

    @Override
    public boolean delete(Commande o) {
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
    public boolean update(Commande o) {
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
    public Commande findById(Long s) {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT c FROM Commande c WHERE c.id=:id", Commande.class)
                .setParameter("id", s)
                .getSingleResult();
    }

    @Override
    public List<Commande> findAll() {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT c FROM Commande c", Commande.class).getResultList();
    }
}
