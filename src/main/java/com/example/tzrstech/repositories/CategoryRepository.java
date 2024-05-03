package com.example.tzrstech.repositories;

import com.example.tzrstech.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findByCategoryName(String name);
    boolean existsByCategoryName(String name);
    Category findByCategoryId(Integer id);
    boolean existsById(Integer id);
}
