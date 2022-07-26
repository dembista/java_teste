package com.jpa.example.vue;

import com.jpa.example.Dao.PersistanceDao;
import com.jpa.example.models.Categorie;
import com.jpa.example.models.Produit;
import com.jpa.example.services.CategorieService;
import com.jpa.example.services.ProduitService;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VueProduits {
    public static void main(){
        PersistanceDao.createTable();
        Scanner input = new Scanner(System.in);
        ProduitService produitService = new ProduitService();
        CategorieService categorieService = new CategorieService();
        String libelle;
        Produit produit = null;
        int choix;
        do {
            System.out.println("1- Ajouter Produit");
            System.out.println("2- Lister Produit");
            System.out.println("3- Supprimer produit");
            System.out.println("4- Modifier produit");
            System.out.println("5- Retour");
            choix=input.nextInt();
            switch (choix){
                case 1:
                    System.out.println("Entrer le libelle du produit");
                    libelle = input.next();
                    Categorie categories2 = new Categorie();
                    System.out.println("Entrer id");
                    int ids = Integer.parseInt(input.next());
                    categories2 = categorieService.rechercheCategorieId((long) ids);
                    produit = new Produit();
                    produit.setLibelle(libelle);
                    produit.setCategorie(categories2);

                    produitService.ajoutProduit(produit);
                    break;
                case 2:
                    System.out.println("Lister les produits");
                    List<Produit> produits = produitService.rechercheProduits();
                    for (Produit next : produits) {
                        System.out.println("next categorie: " + next.getCategorie().getLibelle());
                        System.out.println("next produit: " + next.getLibelle());
                    }
                    break;
                case 3:
                    Produit produit2 = new Produit();
                    System.out.println("Entrer id");
                    int idss = Integer.parseInt(input.next());
                    produit2 = produitService.rechercheProduitId((long) idss);
                   /* System.out.println("Entrer id");
                    Long id = input.nextLong();

                    Produit produit1 = Collections.singletonList(produitService.rechercheProduitId(id));*/
                    if(produit2 == null){
                        System.out.println("Produit not found");
                    }else {
                        produitService.supprimerProduits(produit2);
                    }
                    break;
                case 4:
                    System.out.println("Entrer l'id du produit");
                    int identifier = input.nextInt();
                    produits = Collections.singletonList(produitService.rechercheProduitId((long) identifier));
                    if(produits == null){
                        System.out.println("Produit not found");
                    }else{
                        System.out.println("Entrer le libelle du produit");
                        produit.setLibelle(input.next());
                        Categorie categories3 = new Categorie();
                        System.out.println("Entrer id");
                        int idsss = Integer.parseInt(input.next());
                        categories3 = categorieService.rechercheCategorieId((long) idsss);
                        produit.setCategorie(categories3);
                        produitService.modifyProduits(produit);
                    }
                    break;
                default: System.out.println("Veiller faire un bon choix");
                    break;
            }
        }while(choix != 5);
        //PersistanceDao.closeEntityManagerFactory();
    }
}
