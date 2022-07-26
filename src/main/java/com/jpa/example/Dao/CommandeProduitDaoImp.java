package com.jpa.example.Dao;

import com.jpa.example.models.CommandeProduit;

import javax.persistence.EntityManager;
import java.util.List;

public class CommandeProduitDaoImp implements ICommandeProduit{
    @Override
    public boolean save(CommandeProduit o) {
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
    public boolean delete(CommandeProduit o) {
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
    public boolean update(CommandeProduit o) {
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
    public CommandeProduit findById(Long s) {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT cp FROM CommandeProduit cp WHERE cp.id=:id", CommandeProduit.class)
                .setParameter("id", s)
                .getSingleResult();
    }

    @Override
    public List<CommandeProduit> findAll() {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT cp FROM CommandeProduit cp", CommandeProduit.class)
                .getResultList();
    }
}
