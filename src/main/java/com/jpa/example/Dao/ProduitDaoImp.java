package com.jpa.example.Dao;

import com.jpa.example.models.Categorie;
import com.jpa.example.models.Produit;

import javax.persistence.EntityManager;
import java.util.List;

public class ProduitDaoImp implements IProduit{
    @Override
    public boolean save(Produit o) {
        EntityManager em = PersistanceDao.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(o);
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
    public boolean delete(Produit o) {
        EntityManager em = PersistanceDao.getEntityManager();
        try {
            em.getTransaction().begin();
            em.remove(em.contains(o) ? o : em.merge(o));
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
    public boolean update(Produit o) {
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
    public Produit findById(Long s) {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT p FROM Produit p WHERE p.id=:id", Produit.class)
                .setParameter("id", s)
                .getSingleResult();
    }

    @Override
    public List<Produit> findAll() {
        EntityManager em = PersistanceDao.getEntityManager();
        return em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
    }
}
