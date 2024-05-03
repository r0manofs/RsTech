package com.example.tzrstech.services;

import com.example.tzrstech.services.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();
    ProductDto findByProductId(Integer id);
    List<ProductDto> findByProductName(String productName);
//    List<ProductDto> findByCategoryName(String categoryName);
    List<ProductDto> findByPrice(Integer price);
    List<ProductDto> findByPriceBetween(Integer minPrice, Integer maxPrice);
    ProductDto save(ProductDto product);
    void delete(Integer id);
}
