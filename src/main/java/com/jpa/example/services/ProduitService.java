package com.jpa.example.services;

import com.jpa.example.Dao.IProduit;
import com.jpa.example.Dao.ProduitDaoImp;
import com.jpa.example.models.Produit;

import java.util.List;

public class ProduitService {
    private IProduit iproduit;

    public ProduitService(){
         iproduit = new ProduitDaoImp();
    }

    public boolean ajoutProduit(Produit produit){
        return iproduit.save(produit);
    }

    public Produit rechercheProduitId(Long id){
        return iproduit.findById(id);
    }
    public List<Produit> rechercheProduits(){
        return iproduit.findAll();
    }

    public boolean supprimerProduits(Produit produit){
        return iproduit.delete(produit);
    }
    public boolean modifyProduits(Produit produit){
        return iproduit.update(produit);
    }
}
