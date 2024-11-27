package org.example.repository;

import org.example.entity.Produit; // Entity class representing a product

import java.util.List; // For returning lists of products
import java.util.Optional; // For null-safe operations on products
import java.util.function.Predicate; // For defining filter criteria

/**
 * Interface defining the repository contract for managing Produit entities.
 * Provides CRUD operations and additional search functionality.
 */
public interface IProduitRepository {

    /**
     * Saves a new product to the repository.
     * 
     * @param p The product to be saved.
     * @return The saved product with updated details (e.g., a generated reference).
     */
    Produit save(Produit p);

    /**
     * Retrieves all products from the repository.
     * 
     * @return A list of all products.
     */
    List<Produit> findAll();

    /**
     * Finds a product by its unique reference.
     * 
     * @param ref The reference of the product to find.
     * @return An Optional containing the product if found, or empty if not found.
     */
    Optional<Produit> finfByRef(Long ref); // Note: Consider fixing the method name typo to `findByRef`.

    /**
     *
