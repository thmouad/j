package org.example.entity;

import java.util.Date;

/**
 * Entity class representing a product (Produit).
 * Contains attributes for product details and methods for accessing and modifying them.
 */
public class Produit {

    // Fields representing the properties of a product
    private Long ref; // Reference ID of the product
    private String nom; // Name of the product
    private double prix; // Price of the product
    private double quantiteStock; // Quantity of product in stock
    private Date dateCreation; // Date when the product was created
    private Date datePremption; // Expiration date of the product
    private TypeProduit type; // Type of the product (e.g., Cosmetique, Neutritif)

    /**
     * Default constructor for Produit.
     * Useful for frameworks or cases where a default instance is required.
     */
    public Produit() {
    }

    /**
     * Parameterized constructor for Produit.
     * Initializes all fields of the class.
     * 
     * @param ref Reference ID of the product.
     * @param nom Name of the product.
     * @param prix Price of the product.
     * @param quantiteStock Quantity in stock.
     * @param dateCreation Creation date of the product.
     * @param datePremption Expiration date of the product.
     * @param type Type of the product.
     */
    public Produit(Long ref, String nom, double prix, double quantiteStock, Date dateCreation, Date datePremption, TypeProduit type) {
        this.ref = ref;
        this.nom = nom;
        this.prix = prix;
        this.quantiteStock = quantiteStock;
        this.dateCreation = dateCreation;
        this.datePremption = datePremption;
        this.type = type;
    }

    // Getters: Provide read-only access to the fields

    public Long getRef() {
        return ref;
    }

    public String getNom() {
        return nom;
    }

    public double getPrix() {
        return prix;
    }

    public double getQuantiteStock() {
        return quantiteStock;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public Date getDatePremption() {
        return datePremption;
    }

    public TypeProduit getType() {
        return type;
    }

    // Setters: Allow modification of the fields

    public void setRef(Long ref) {
        this.ref = ref;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public void setQuantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public void setDatePremption(Date datePremption) {
        this.datePremption = datePremption;
    }

    public void setType(TypeProduit type) {
        this.type = type;
    }

    /**
     * Returns a string representation of the product.
     * 
     * @return A formatted string with all the product details.
     */
    @Override
    public String toString() {
        return "Produit{" +
                "ref=" + ref +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", quantiteStock=" + quantiteStock +
                ", dateCreation=" + dateCreation +
                ", datePremption=" + datePremption +
                ", type=" + type +
                '}';
    }
}
