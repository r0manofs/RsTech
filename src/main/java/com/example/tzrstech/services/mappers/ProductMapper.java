package com.example.tzrstech.services.mappers;

import com.example.tzrstech.entities.Product;
import com.example.tzrstech.services.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "productId", source = "productId", ignore = true)
    Product dtoToEntity(ProductDto productDto);
    ProductDto entityToDto(Product product);
    List<ProductDto> toListDto(List<Product> products);
    @Mapping(target = "productId", source = "productId", ignore = true)
    void updateProduct(ProductDto updatedProduct, @MappingTarget Product product);
}
