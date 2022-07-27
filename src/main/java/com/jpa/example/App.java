package com.jpa.example;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;


import com.jpa.example.Dao.PersistanceDao;
import com.jpa.example.models.*;
import com.jpa.example.services.CategorieService;
import com.jpa.example.services.ClientService;
import com.jpa.example.services.ProduitService;
import com.jpa.example.vue.VueCategories;
import com.jpa.example.vue.VueProduits;
import com.jpa.example.vue.VueUsers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PersistanceDao.createTable();
        //Appel de la vue categorie
        VueCategories vueCategories = new VueCategories();
        //Appel de la vue produit
        VueProduits vueProduits = new VueProduits();
        //Appel de la vue Users
        VueUsers vueUsers = new VueUsers();

        Scanner input = new Scanner(System.in);
       //Variable choix
        int choix1;
        do {
            //MENU PRINCIPAL
            System.out.println("1- User");
            System.out.println("2- Produit");
            System.out.println("3- Categorie");
            System.out.println("4- Quitter");
            choix1=input.nextInt();
            switch(choix1){
                case 1:
                    vueUsers.main();
                    break;
                    case 2:
                        vueProduits.main();
                        break;
                case 3:
                    vueCategories.main();
                    break;
                    default:
                        break;
            }
        }while(choix1 != 4);
        PersistanceDao.closeEntityManagerFactory();
           /*
            switch(choix){

                case 1:
                    System.out.println("Entrer le login de la personne");
                    email = input.next();
                    System.out.println("Entrer le mot de passe de la personne");
                    password = input.next();
                    Role role = new Role();
                    role.setId(1L);
                    System.out.println("Entrer le mot telephone de la personne");
                    telephone = input.next();
                    System.out.println("Entrer la ville de la personne");
                    adress.setVille(input.next());
                    System.out.println("Entrer le TELEPHONE de la DESTINATION");
                    adress.setNumTelephone(input.next());
                    System.out.println("Entrer la quartier de la personne");
                    adress.setQuartier(input.next());
                    System.out.println("Entrer l' adresse du client");
                    adresse = input.next();
                    Client user = new Client();
                    user.setRole(role);
                    user.setEmail(email);
                    user.setPassword(password);
                    user.setTelephone(telephone);
                    user.setAdresse(adresse);
                    user.setAdress(adress);

                    clientService.saveClient(user);
                    break;
                case 2:
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
                case 3:
                    System.out.println("Entrer le libelle de la categorie");
                    libelle = input.next();
                    Categorie categories = new Categorie();
                    categories.setLibelle(libelle);
                    categorieService.ajoutCategorie(categories);
                    break;
                case 4:
                    /*System.out.println("Lister les personnes");
                    ClientService clientServices = new ClientService();
                    List<Client> clients = clientServices.findAllClient();
                    for(Client c : clients) {
                        System.out.println("########## ID " + c.getId() + "#################");
                        System.out.println("Email : " + c.getEmail());
                        System.out.println("Password : " + c.getPassword());
                        System.out.println("Adresse : " + c.getAddress());
                        System.out.println("Telephone : " + c.getTelephone());
                    }
                    break;
                case 5:
                    System.out.println("Lister les produits");
                    List<Produit> produits = produitService.rechercheProduits();
                    for (Produit next : produits) {
                        System.out.println("next categorie: " + next.getCategorie().getLibelle());
                        System.out.println("next produit: " + next.getLibelle());
                    }
                    break;
                case 6:
                    System.out.println("Lister les categories");
                    List<Categorie> categorie = categorieService.rechercheCategories();
                    for (Categorie next : categorie) {
                        System.out.println("next categorie: " + next.getLibelle());
                    }
                    break;
                case 7:
                    Produit produit2 = new Produit();
                    System.out.println("Entrer id");
                    int idss = Integer.parseInt(input.next());
                    produit2 = produitService.rechercheProduitId((long) idss);
                   /* System.out.println("Entrer id");
                    Long id = input.nextLong();

                    Produit produit1 = Collections.singletonList(produitService.rechercheProduitId(id));
                    if(produit2 == null){
                        System.out.println("Produit not found");
                    }else {
                        produitService.supprimerProduits(produit2);
                    }
                    break;
                    case 8:
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

             */
       /* EntityManagerFactory emf = null;
        EntityManager entityManager = null;
        EntityTransaction transaction = null;
        try {
          emf = Persistence.createEntityManagerFactory("userPU");
          entityManager = emf.createEntityManager();
          transaction = entityManager.getTransaction();
          transaction.begin();
            Scanner input = new Scanner(System.in);
            int choix;
            String email, password;
            String libelle;
            Categorie categorie = null;
            do {
                System.out.println("1- Ajouter User");
                System.out.println("2- Ajouter Produit");
                System.out.println("3- Ajouter Categorie");
                System.out.println("4- Lister User");
                System.out.println("5- Lister Produit");
                System.out.println("6- Lister Categorie");
                System.out.println("7- Quitter");
                choix=input.nextInt();

                switch(choix){
                    case 1:
                        System.out.println("Entrer le login de la personne");
                        email = input.next();
                        System.out.println("Entrer le mot de passe de la personne");
                        password = input.next();
                        Role role = new Role();
                        role.setLibelle("ADMIN");
                        User user = new User();
                        user.setRole(role);
                        user.setEmail(email);
                        user.setPassword(password);
                        entityManager.persist(role);
                        entityManager.persist(user);
                        transaction.commit();
                        entityManager.close();
                        break;
                    case 2:
                        System.out.println("Entrer le libelle du produit");
                        libelle = input.next();
                        if (categorie != null){
                            categorie = input.next();
                        }
                        Produit produit = new Produit();
                        produit.setLibelle(libelle);
                        produit.setCategorie(categorie);
                        entityManager.persist(produit);
                        transaction.commit();
                        entityManager.close();
                        break;
                    case 3:
                        System.out.println("Entrer le libelle de la categorie");
                        libelle = input.next();
                        Categorie categories = new Categorie();
                        categories.setLibelle(libelle);
                        entityManager.persist(categories);
                        transaction.commit();
                        entityManager.close();
                        break;
                        case 4:
                            System.out.println("Lister les personnes");
                            Query k = entityManager.createQuery("select u from User u");
                            List<User> result = k.getResultList();
                            System.out.println("num of users:" + result.size());
                            for (User next : result) {
                                System.out.println("next user: " + next.getEmail());
                                System.out.println("next user: " + next.getPassword());
                                System.out.println("next user: " + next.getRole());
                            }
                            break;
                            case 5:
                                System.out.println("Lister les produits");
                                Query g = entityManager.createQuery("select p from Produit p");
                                List<Produit> resultat = g.getResultList();
                                System.out.println("num of produits:" + resultat.size());
                                for (Produit next : resultat) {
                                    System.out.println("next user: " + next.getCategorie());
                                    System.out.println("next user: " + next.getLibelle());
                                }
                                break;
                                case 6:
                                    System.out.println("Lister les categories");
                                    Query c = entityManager.createQuery("select p from Produit p");
                                    List<Categorie> resultats = c.getResultList();
                                    System.out.println("num of produits:" + resultats.size());
                                    for (Categorie next : resultats) {
                                        System.out.println("next categorie: " + next.getLibelle());
                                    }
                                    break;
                    default: System.out.println("Veiller faire un bon choix");
                        break;
                }

              }while(choix != 7);
          transaction.commit();
          Query q = entityManager.createQuery("select r from Role r");
          List<Role> resultList = q.getResultList();
          System.out.println("num of roles:" + resultList.size());
          for (Role next : resultList) {
            System.out.println("next role: " + next.getLibelle());
          }



        } catch (Exception e) {
          System.out.println(e);
          transaction.rollback();
        } finally {
          entityManager.close();
          emf.close();
        }
        */
    }
}
