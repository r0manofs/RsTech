package com.example.tzrstech.services.mappers;

import com.example.tzrstech.entities.Product;
import com.example.tzrstech.services.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-26T14:22:43+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product dtoToEntity(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setProductName( productDto.getProductName() );
        product.setDescription( productDto.getDescription() );
        product.setPrice( productDto.getPrice() );
        product.setAppearenceDate( productDto.getAppearenceDate() );
        product.setStatus( productDto.isStatus() );
        product.setCategory( productDto.getCategory() );

        return product;
    }

    @Override
    public ProductDto entityToDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        productDto.setProductId( product.getProductId() );
        productDto.setProductName( product.getProductName() );
        productDto.setDescription( product.getDescription() );
        productDto.setPrice( product.getPrice() );
        productDto.setAppearenceDate( product.getAppearenceDate() );
        productDto.setStatus( product.isStatus() );
        productDto.setCategory( product.getCategory() );

        return productDto;
    }

    @Override
    public List<ProductDto> toListDto(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDto> list = new ArrayList<ProductDto>( products.size() );
        for ( Product product : products ) {
            list.add( entityToDto( product ) );
        }

        return list;
    }

    @Override
    public void updateProduct(ProductDto updatedProduct, Product product) {
        if ( updatedProduct == null ) {
            return;
        }

        product.setProductName( updatedProduct.getProductName() );
        product.setDescription( updatedProduct.getDescription() );
        product.setPrice( updatedProduct.getPrice() );
        product.setAppearenceDate( updatedProduct.getAppearenceDate() );
        product.setStatus( updatedProduct.isStatus() );
        product.setCategory( updatedProduct.getCategory() );
    }
}
