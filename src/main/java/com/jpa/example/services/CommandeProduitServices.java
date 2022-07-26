package com.jpa.example.services;

import com.jpa.example.Dao.CommandeProduitDaoImp;
import com.jpa.example.Dao.ICommandeProduit;
import com.jpa.example.models.CommandeProduit;

import java.util.List;

public class CommandeProduitServices {
    private ICommandeProduit iCommandeProduit;

    public CommandeProduitServices(){
        iCommandeProduit = new CommandeProduitDaoImp();
    }

    public boolean estCommander(CommandeProduit commandeProduit){
        return iCommandeProduit.save(commandeProduit);
    }

    public CommandeProduit rechercheCommandeProduitId(Long id){
        return iCommandeProduit.findById(id);
    }

    public List<CommandeProduit> lesCommandeProduits(){
        return iCommandeProduit.findAll();
    }
}
