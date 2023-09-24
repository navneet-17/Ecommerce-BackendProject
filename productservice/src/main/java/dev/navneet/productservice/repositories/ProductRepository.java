package dev.navneet.productservice.repositories;

import dev.navneet.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
     // Get the product by title
    Product findByTitle(String title);
     //Get a product by title and price
     Product findByTitleAndPrice_Price(String title, Double price);

    //Get a product by id
    Optional<Product> findById(UUID id);


     //Get all products by currency
     List<Product> findAllByPrice_Currency(String currency);

    //** Count the number of products in the database for a particular currency:
    Long countByPrice_Currency(String currency);

    // Custom query using the @Query annotation to get all the products with a specific title:
    @Query(name= "SELECT p FROM products p WHERE p.title = :title", nativeQuery = true)
    List<Product> findAllProductsByTitle(String title);

    // re-writing the above query using custom query interface
    @Query(value = CustomQueries.FIND_ALL_BY_TITLE, nativeQuery = true)
    List<Product> findAllByTitle(String naman);



}









