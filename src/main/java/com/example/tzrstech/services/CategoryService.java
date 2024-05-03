package com.example.tzrstech.services;

import com.example.tzrstech.services.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findByCategoryId(Integer id);
    List<CategoryDto> findByCategoryName(String categoryName);
    CategoryDto save(CategoryDto category);
    void update(Integer id, CategoryDto updatedCategory);
    void delete(Integer id);
}
