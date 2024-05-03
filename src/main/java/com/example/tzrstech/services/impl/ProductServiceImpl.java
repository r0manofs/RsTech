package com.example.tzrstech.services.impl;

import com.example.tzrstech.entities.Product;
import com.example.tzrstech.exceptions.EmptyCategoryException;
import com.example.tzrstech.exceptions.EntityNotFoundException;
import com.example.tzrstech.exceptions.InvalidCategoryException;
import com.example.tzrstech.repositories.CategoryRepository;
import com.example.tzrstech.repositories.ProductRepository;
import com.example.tzrstech.services.ProductService;
import com.example.tzrstech.services.dto.ProductDto;
import com.example.tzrstech.services.mappers.ProductMapper;
import jakarta.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDto> findAll() {
        return productMapper.toListDto(productRepository.findAll());
    }

    public ProductDto findByProductId(Integer id) {
        return Optional.ofNullable(getById(id)).map(productMapper::entityToDto).get();
    }

    private Product getById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
    }

    public List<ProductDto> findByProductName(String productName) {
        if (productRepository.existsByProductName(productName))
            return productMapper.toListDto(
                    productRepository.findByProductName(productName));
        else throw new EntityNotFoundException(productName);
    }

//    public List<ProductDto> findByCategoryName(String categoryName) {
//        return productMapper.toListDto(
//                productRepository.findByCategoryName(categoryName));
//    }

    public List<ProductDto> findByPrice(Integer price) {
        return productMapper.toListDto(
                productRepository.findByPrice(price));
    }

    public List<ProductDto> findByPriceBetween(Integer minPrice, Integer maxPrice) {
        return productMapper.toListDto(
                productRepository.findByPriceBetween(minPrice, maxPrice));
    }

    public ProductDto save(ProductDto product) throws ConstraintViolationException {
        if (isCategoryEmpty(product))
            throw new EmptyCategoryException();
        if (!isCategoryValid(product)) {
            throw new InvalidCategoryException();
        } else return productMapper.entityToDto(productRepository.save(
                productMapper.dtoToEntity(product)));
    }

    public ProductDto newProductNewCategory(ProductDto product) throws ConstraintViolationException {
        categoryRepository.save(product.getCategory());
        return productMapper.entityToDto(productRepository.save(
                productMapper.dtoToEntity(product)));
    }

    public void update(Integer id, ProductDto updatedProduct) throws ConstraintViolationException {
        if (!productRepository.existsById(id))
            throw new EntityNotFoundException(id);
        //TODO Т.к я тут уже проверяю,
        // может быть Optional уже и не нужен
        //Для понимания lambda и пр. () это byId
        Optional<Product> product = productRepository.findById(id);
        product.ifPresent(entity -> {
            productMapper.updateProduct(updatedProduct, entity);
            productRepository.saveAndFlush(entity);
        });
    }

    public void delete(Integer id) {
        if (!productRepository.existsById(id))
            throw new EntityNotFoundException(id);
        productRepository.deleteById(id);
    }

    private boolean isCategoryValid(ProductDto product) {
        Integer productsCategoryId = product.getCategory().getCategoryId();
        if (categoryRepository.existsById(productsCategoryId) &&
                categoryRepository.findByCategoryId(productsCategoryId).equals(product.getCategory()))
            return true;
        return false;
    }

    private boolean isCategoryEmpty(ProductDto product) {
        return product.getCategory().getCategoryId() == null ||
                product.getCategory().getCategoryName() == null;
    }
}
