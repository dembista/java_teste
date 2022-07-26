package com.jpa.example.vue;

import com.jpa.example.Dao.PersistanceDao;
import com.jpa.example.models.Adresse;
import com.jpa.example.models.Client;
import com.jpa.example.models.Role;
import com.jpa.example.services.ClientService;

import java.util.List;
import java.util.Scanner;

public class VueUsers {
    public static void main(){

        PersistanceDao.createTable();
        Scanner input = new Scanner(System.in);
        ClientService clientService = new ClientService();
        String email,password,telephone;
        Adresse adress = new Adresse();
        int choix;
        do{
            System.out.println("1- Ajouter User");
            System.out.println("2- Lister User");
            System.out.println("3- Retour");

            choix=input.nextInt();

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
                String adresse = input.next();
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
                    System.out.println("Lister les personnes");
                    ClientService clientServices = new ClientService();
                    List<Client> clients = clientServices.findAllClient();
                    for(Client c : clients) {
                        System.out.println("########## ID " + c.getId() + "#################");
                        System.out.println("Email : " + c.getEmail());
                        System.out.println("Password : " + c.getPassword());
                        System.out.println("Telephone : " + c.getTelephone());
                    }
                    break;
                default: System.out.println("Veiller faire un bon choix");
                    break;

            }


        } while(choix != 3);
        //PersistanceDao.closeEntityManagerFactory();
    }
}
