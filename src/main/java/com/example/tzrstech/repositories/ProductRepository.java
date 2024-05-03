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
    List<Product> findByPrice(Integer price);
    List<Product> findByPriceBetween(Integer minPrice, Integer maxPrice);
    List<Product> findByCategory(Category category);
}
