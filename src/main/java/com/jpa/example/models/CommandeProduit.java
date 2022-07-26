package com.jpa.example.models;

import javax.persistence.*;

public class CommandeProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "commande", referencedColumnName = "id")
    private Commande commande;

    @OneToOne
    @JoinColumn(name = "produit", referencedColumnName = "id")
    private Produit produit;


    /**
     * get field @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

      *
      * @return id @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     */
    public Long getId() {
        return this.id;
    }

    /**
     * set field @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

      *
      * @param id @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * get field @ManyToOne
     @JoinColumn(name = "commande", referencedColumnName = "id")

      *
      * @return commande @ManyToOne
     @JoinColumn(name = "commande", referencedColumnName = "id")

     */
    public Commande getCommande() {
        return this.commande;
    }

    /**
     * set field @ManyToOne
     @JoinColumn(name = "commande", referencedColumnName = "id")

      *
      * @param commande @ManyToOne
     @JoinColumn(name = "commande", referencedColumnName = "id")

     */
    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    /**
     * get field @ManyToOne
     @JoinColumn(name = "produit", referencedColumnName = "id")

      *
      * @return produit @ManyToOne
     @JoinColumn(name = "produit", referencedColumnName = "id")

     */
    public Produit getProduit() {
        return this.produit;
    }

    /**
     * set field @ManyToOne
     @JoinColumn(name = "produit", referencedColumnName = "id")

      *
      * @param produit @ManyToOne
     @JoinColumn(name = "produit", referencedColumnName = "id")

     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
