package org.example.entity;

import java.util.Date;

/**
 * Builder class for creating instances of the Produit class.
 * Utilizes the Builder design pattern to simplify object creation and allow for method chaining.
 */
public class ProduitBuilder {

    // Fields corresponding to the Produit class properties
    private Long ref; // Reference ID of the product
    private String nom; // Name of the product
    private double prix; // Price of the product
    private double quantiteStock; // Quantity in stock
    private Date dateCreation; // Date when the product was created
    private Date datePremption; // Expiration date of the product
    private TypeProduit type; // Type of the product (e.g., Cosmetique, Neutritif)

    /**
     * Sets the reference ID of the product.
     * 
     * @param ref The product reference.
     * @return The current instance of ProduitBuilder for chaining.
     */
    public ProduitBuilder ref(Long ref) {
        this.ref = ref;
        return this;
    }

    /**
     * Sets the name of the product.
     * 
     * @param nom The product name.
     * @return The current instance of ProduitBuilder for chaining.
     */
    public ProduitBuilder nom(String nom) {
        this.nom = nom;
        return this;
    }

    /**
     * Sets the price of the product.
     * 
     * @param prix The product price.
     * @return The current instance of ProduitBuilder for chaining.
     */
    public ProduitBuilder prix(double prix) {
        this.prix = prix;
        return this;
    }

    /**
     * Sets the stock quantity of the product.
     * 
     * @param quantiteStock The quantity in stock.
     * @return The current instance of ProduitBuilder for chaining.
     */
    public ProduitBuilder quantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
        return this;
    }

    /**
     * Sets the creation date of the product.
     * 
     * @param dateCreation The creation date.
     * @return The current instance of ProduitBuilder for chaining.
     */
    public ProduitBuilder dateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    /**
     * Sets the expiration date of the product.
     * 
     * @param datePremption The expiration date.
     * @return The current instance of ProduitBuilder for chaining.
     */
    public ProduitBuilder datePremption(Date datePremption) {
        this.datePremption = datePremption;
        return this;
    }

    /**
     * Sets the type of the product.
     * 
     * @param type The product type (e.g., Cosmetique, Neutritif).
     * @return The current instance of ProduitBuilder for chaining.
     */
    public ProduitBuilder type(TypeProduit type) {
        this.type = type;
        return this;
    }

    /**
     * Builds and returns an instance of the Produit class using the specified values.
     * 
     * @return A new instance of Produit initialized with the builder's values.
     */
    public Produit build() {
        // Construct and return a new Produit instance with the provided values
        return new Produit(ref, nom, prix, quantiteStock, dateCreation, datePremption, type);
    }
}
