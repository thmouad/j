package org.example.repository;

import org.example.entity.Produit;
import org.example.entity.ProduitBuilder; // Builder for creating Produit objects
import org.example.entity.TypeProduit; // Enum or class representing product types

import java.util.*; // For data structures like Map and List
import java.util.function.Predicate; // For functional-style filtering
import java.util.stream.Collectors; // For converting streams to lists

/**
 * Implementation of the IProduitRepository interface.
 * This class uses a Singleton pattern and manages Produit entities with CRUD operations.
 */
public class ProduitRepositoryImpl implements IProduitRepository {

    // In-memory data store for products, using a HashMap with the product reference as the key
    private Map<Long, Produit> produits = new HashMap<>();
    private long nbrProduit; // Counter for generating unique product references

    // Singleton instance of the repository
    private static ProduitRepositoryImpl produitRepository;

    /**
     * Private constructor to enforce Singleton pattern.
     * Calls the init() method to populate the repository with initial data.
     */
    private ProduitRepositoryImpl() {
        init();
    }

    /**
     * Saves a new product into the repository.
     * Assigns a unique reference to the product and adds it to the map.
     * 
     * @param p The product to save.
     * @return The saved product with its reference set.
     */
    @Override
    public Produit save(Produit p) {
        Long ref = ++nbrProduit; // Increment the product counter to generate a new reference
        p.setRef(ref); // Set the reference to the product
        produits.put(ref, p); // Add the product to the map
        return p; // Return the saved product
    }

    /**
     * Retrieves all products from the repository.
     * 
     * @return A list of all products.
     */
    @Override
    public List<Produit> findAll() {
        return produits.values().stream().collect(Collectors.toList()); // Convert map values to a list
    }

    /**
     * Finds a product by its reference.
     * 
     * @param ref The reference of the product to find.
     * @return An Optional containing the product if found, or empty if not found.
     */
    @Override
    public Optional<Produit> finfByRef(Long ref) {
        Produit prd = produits.get(ref); // Retrieve the product from the map
        return Optional.ofNullable(prd); // Wrap the product in an Optional (null-safe)
    }

    /**
     * Updates an existing product in the repository.
     * 
     * @param p The updated product.
     * @return The updated product.
     */
    @Override
    public Produit update(Produit p) {
        produits.put(p.getRef(), p); // Replace the product in the map
        return p; // Return the updated product
    }

    /**
     * Deletes a product from the repository by its reference.
     * 
     * @param ref The reference of the product to delete.
     */
    @Override
    public void detele(Long ref) {
        produits.remove(ref); // Remove the product from the map
    }

    /**
     * Searches for products in the repository that match the given predicate.
     * 
     * @param predicate The condition to filter products.
     * @return A list of products that match the predicate.
     */
    @Override
    public List<Produit> search(Predicate<Produit> predicate) {
        return produits.values().stream()
                .filter(predicate) // Apply the predicate as a filter
                .collect(Collectors.toList()); // Collect matching products into a list
    }

    /**
     * Initializes the repository with some default products.
     * This is useful for testing or as sample data.
     */
    private void init() {
        save(new ProduitBuilder()
                .nom("Libre") // Product name
                .prix(580.23) // Product price
                .type(TypeProduit.Cosmitique) // Product type
                .quantiteStock(100) // Stock quantity
                .build()); // Build the product

        save(new ProduitBuilder()
                .nom("yaourt")
                .prix(12.45)
                .type(TypeProduit.Neutritif)
                .quantiteStock(300)
                .build());

        save(new ProduitBuilder()
                .nom("Gel Cheveux")
                .prix(100.00)
                .type(TypeProduit.Cosmitique)
                .quantiteStock(50)
                .build());
    }

    /**
     * Retrieves the singleton instance of the repository.
     * If the instance doesn't exist, it creates one.
     * 
     * @return The singleton instance of ProduitRepositoryImpl.
     */
    public static ProduitRepositoryImpl getInstence() {
        if (produitRepository == null) {
            produitRepository = new ProduitRepositoryImpl(); // Create a new instance if none exists
        }
        return produitRepository; // Return the singleton instance
    }
}
