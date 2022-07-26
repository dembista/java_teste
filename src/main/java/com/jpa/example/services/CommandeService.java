package com.jpa.example.services;

import com.jpa.example.Dao.CommandeDaoImp;
import com.jpa.example.Dao.ICommande;
import com.jpa.example.models.Commande;

import java.util.List;

public class CommandeService {
    private ICommande icommande;

    public CommandeService(){
        icommande = new CommandeDaoImp();
    }

    public boolean FaireCommande(Commande commande){
        return icommande.save(commande);
    }

    public Commande rechercheCommandeId(Long id){
        return icommande.findById(id);
    }

    public List<Commande> rechercheCommande(){
        return icommande.findAll();
    }
}
