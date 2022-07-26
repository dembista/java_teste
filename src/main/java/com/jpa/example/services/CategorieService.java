package com.jpa.example.services;

import com.jpa.example.Dao.CategorieDaoImp;
import com.jpa.example.Dao.ICategorie;
import com.jpa.example.models.Categorie;

import java.util.List;

public class CategorieService {
    private ICategorie iCategorie;

    public CategorieService(){
         iCategorie = new CategorieDaoImp();
    }
    public boolean ajoutCategorie(Categorie categorie){
       return iCategorie.save(categorie);
    }
    public Categorie rechercheCategorieId(Long id){
        return iCategorie.findById(id);
    }
    public List<Categorie> rechercheCategories(){
        return iCategorie.findAll();
    }
}
