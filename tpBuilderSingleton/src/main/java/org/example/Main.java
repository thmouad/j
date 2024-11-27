package org.example;

// Import necessary classes and packages
import org.example.entity.Produit;
import org.example.entity.ProduitBuilder; // Builder pattern for creating Produit objects
import org.example.entity.TypeProduit; // Enum or class representing product types
import org.example.repository.ProduitRepositoryImpl; // Repository for CRUD operations on Produit objects

import java.util.Date; // For handling product creation dates
import java.util.List; // For handling lists of products
import java.util.Optional; // To handle optional values when searching for products
import java.util.function.Predicate; // Functional interface for filtering products

/**
 * Main class that demonstrates CRUD operations on Produit entities.
 */
public class Main {
    public static void main(String[] args) {

        // Example of using the builder pattern to create a product (commented out in the current code)
        /*
        Produit p1=new ProduitBuilder()
                .ref(1L)
                .nom("Yaourt") // Set the product name
                .prix(10.23) // Set the product price
                .dateCreation(new Date()) // Set the creation date to the current date
                .type(TypeProduit.Neutritif) // Set the product type
                .build();

        System.out.println(p1.toString()); // Print the product details
        */

        // Singleton instance of ProduitRepositoryImpl to manage Produit entities
        ProduitRepositoryImpl pri = ProduitRepositoryImpl.getInstence();

        // Display all products currently in the repository
        System.out.println("=====================Afficher tous les produits===========================");
        List<Produit> prds = pri.findAll(); // Retrieve all products
        for (Produit p : prds) // Iterate over products and display their details
            System.out.println(p.toString());

        // Adding a new product to the repository
        System.out.println("=====================Ajouter un nouveau produit===========================");
        Produit p = new ProduitBuilder()
                  .nom("Lait") // Set product name to "Lait"
                  .prix(10) // Set product price to 10
                  .quantiteStock(500) // Set product stock quantity
                  .type(TypeProduit.Neutritif) // Set product type
                  .build();
        pri.save(p); // Save the new product in the repository

        // Display all products after adding the new product
        for (Produit p1 : pri.findAll())
            System.out.println(p1.toString());

        // Searching for a product by its reference
        System.out.println("=====================Chercher un Produit===========================");
        Optional<Produit> prd = pri.finfByRef(4L); // Search for product with reference 4
        if (prd.isPresent()) // If product is found, print its details
            System.out.println(prd.toString());

        // Updating an existing product
        System.out.println("=====================Modifier un Produit===========================");
        Produit p2 = new ProduitBuilder()
                .ref(4L) // Reference of the product to update
                .nom("Lait") // Updated product name
                .prix(13) // Updated product price
                .quantiteStock(1500) // Updated stock quantity
                .type(TypeProduit.Neutritif) // Updated product type
                .build();
        pri.update(p2); // Update the product in the repository

        // Display all products after updating
        for (Produit p1 : pri.findAll())
            System.out.println(p1.toString());

        // Deleting a product from the repository
        System.out.println("=====================Supprimer un Produit===========================");
        pri.detele(4L); // Delete product with reference 4
        for (Produit p1 : pri.findAll()) // Display remaining products
            System.out.println(p1.toString());

        // Searching for products based on specific criteria using a Predicate
        System.out.println("=====================chercher un Produit===========================");
        List<Produit> prds1 = pri.search(
            new Predicate<Produit>() {
                @Override
                public boolean test(Produit p) {
                    // Define criteria: product type is "Cosmitique" and stock quantity > 80
                    return (p.getType().equals(TypeProduit.Cosmitique)
                            && p.getQuantiteStock() > 80);
                }
            }
        );

        // Display products that match the search criteria
        for (Produit p1 : prds1)
            System.out.println(p1.toString());
    }
}
