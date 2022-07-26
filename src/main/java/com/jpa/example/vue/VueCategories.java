package com.jpa.example.vue;

import com.jpa.example.Dao.PersistanceDao;
import com.jpa.example.models.Categorie;
import com.jpa.example.services.CategorieService;

import java.util.List;
import java.util.Scanner;

public class VueCategories {
    public static void main() {
        PersistanceDao.createTable();
        Scanner input = new Scanner(System.in);
        CategorieService categorieService = new CategorieService();
        String libelle;
        int choix;
        do {
            System.out.println("1- Ajouter categorie");
            System.out.println("2- Lister categorie");
            System.out.println("3- Retour");
            choix = input.nextInt();
            switch (choix){
                case 1:
                    System.out.println("Entrer le libelle de la categorie");
                    libelle = input.next();
                    Categorie categories = new Categorie();
                    categories.setLibelle(libelle);
                    categorieService.ajoutCategorie(categories);
                    break;
                case 2:
                    System.out.println("Lister les categories");
                    List<Categorie> categorie = categorieService.rechercheCategories();
                    for (Categorie next : categorie) {
                        System.out.println("next categorie: " + next.getLibelle());
                    }
                    break;
                default: System.out.println("Veiller faire un bon choix");
                    break;
            }
        }while(choix != 3);
        //PersistanceDao.closeEntityManagerFactory();
        //input.close();
    }
}
