package com.example.tzrstech.repositories;

import com.example.tzrstech.entities.Category;
import com.example.tzrstech.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findById(Integer id);
    boolean existsById(Integer id);
    List<Product> findByProductName(String productName);
    boolean existsByProductName(String productName);
//    @Query("select p from bi2.product p, bi2.category c " +
//            "where p.category = c.category_id and c.category_name = :categoryName")
//    List<Product> findByCategoryName(@Param("categoryName") String categoryName);
    List<Product> findByPrice(Integer price);
    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);
    List<Product> findByCategory(Category category);
}
