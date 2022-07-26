package com.jpa.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("CLIENT")
public class Client extends User{

private String telephone;
    @OneToMany(mappedBy = "client")
    private List<Compte> comptes = new ArrayList<>();

    @Embedded
    private Adresse adress;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    private String adresse;

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Adresse getAdress() {
        return adress;
    }

    public void setAdress(Adresse adress) {
        this.adress = adress;
    }

}
