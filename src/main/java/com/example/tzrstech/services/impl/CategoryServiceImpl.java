package com.example.tzrstech.services.impl;

import com.example.tzrstech.entities.Category;
import com.example.tzrstech.entities.Product;
import com.example.tzrstech.exceptions.EntityNotFoundException;
import com.example.tzrstech.repositories.CategoryRepository;
import com.example.tzrstech.repositories.ProductRepository;
import com.example.tzrstech.services.CategoryService;
import com.example.tzrstech.services.dto.CategoryDto;
import com.example.tzrstech.services.mappers.CategoryMapper;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ProductRepository productRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.categoryMapper = categoryMapper;
    }

    public List<CategoryDto> findAll() {
        return categoryMapper.toListDto(categoryRepository.findAll());
    }

    public CategoryDto findByCategoryId(Integer id) {
        return Optional.of(getById(id)).map(categoryMapper::entityToDto).get();
    }

    private Category getById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    public List<CategoryDto> findByCategoryName(String categoryName) {
        if (categoryRepository.existsByCategoryName(categoryName))
            return categoryMapper.toListDto(
                    categoryRepository.findByCategoryName(categoryName));
        else
            throw new EntityNotFoundException(categoryName);
    }

    public CategoryDto save(CategoryDto category) throws ConstraintViolationException {
        return categoryMapper.entityToDto(categoryRepository.save(
                categoryMapper.dtoToEntity(category)));
    }

    public void update(Integer id, CategoryDto updatedCategory) throws ConstraintViolationException {
        Optional<Category> category = categoryRepository.findById(id);
        category.ifPresent(entity -> {
            categoryMapper.updateCategory(updatedCategory, entity);
            categoryRepository.saveAndFlush(entity);
        });
    }

    @Transactional
    public void delete(Integer id) {
        Category category = categoryRepository.findByCategoryId(id);
        if (categoryRepository.existsById(id)) {
            List<Product> products = productRepository.findByCategory(category);
            products.forEach(product -> {
                product.setStatus(false);
                product.setCategory(null);
            });
            productRepository.saveAll(products);
            categoryRepository.deleteById(id);
        } else
            throw new EntityNotFoundException(id);
    }
}
