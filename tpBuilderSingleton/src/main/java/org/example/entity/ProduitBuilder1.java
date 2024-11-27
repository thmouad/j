package org.example.entity;

import java.util.Date;

/**
 * Builder class for constructing instances of the Produit class.
 * This class uses the Builder design pattern to provide a flexible way of creating complex objects.
 */
public class ProduitBuilder1 {

    // Fields corresponding to the Produit class properties
    private Long ref;
    private String nom;
    private double prix;
    private double quantiteStock;
    private Date dateCreation;
    private Date datePeremption;
    private TypeProduit type;

    /**
     * Sets the reference ID of the product.
     * 
     * @param ref The product reference.
     * @return The current instance of ProduitBuilder1 for chaining.
     */
    public ProduitBuilder1 ref(Long ref) {
        this.ref = ref;
        return this; // Enable method chaining
    }

    /**
     * Sets the name of the product.
     * 
     * @param nom The product name.
     * @return The current instance of ProduitBuilder1 for chaining.
     */
    public ProduitBuilder1 nom(String nom) {
        this.nom = nom;
        return this;
    }

    /**
     * Sets the price of the product.
     * 
     * @param prix The product price.
     * @return The current instance of ProduitBuilder1 for chaining.
     */
    public ProduitBuilder1 prix(double prix) {
        this.prix = prix;
        return this;
    }

    /**
     * Sets the stock quantity of the product.
     * 
     * @param quantiteStock The quantity of the product in stock.
     * @return The current instance of ProduitBuilder1 for chaining.
     */
    public ProduitBuilder1 quantiteStock(double quantiteStock) {
        this.quantiteStock = quantiteStock;
        return this;
    }

    /**
     * Sets the creation date of the product.
     * 
     * @param dateCreation The creation date.
     * @return The current instance of ProduitBuilder1 for chaining.
     */
    public ProduitBuilder1 dateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
        return this;
    }

    /**
     * Sets the expiration date of the product.
     * 
     * @param datePeremption The expiration date.
     * @return The current instance of ProduitBuilder1 for chaining.
     */
    public ProduitBuilder1 datePremption(Date datePeremption) {
        this.datePeremption = datePeremption;
        return this;
    }

    /**
     * Sets the type of the product.
     * 
     * @param type The type of the product (e.g., Cosmetique, Neutritif).
     * @return The current instance of ProduitBuilder1 for chaining.
     */
    public ProduitBuilder1 type(TypeProduit type) {
        this.type = type;
        return this;
    }

    /**
     * Builds and returns an instance of the Produit class using the provided values.
     * 
     * @return A new Produit instance.
     */
    public Produit build() {
        // Construct and return a new Produit instance with the specified values
        return new Produit(ref, nom, prix, quantiteStock, dateCreation, datePeremption, type);
    }
}
