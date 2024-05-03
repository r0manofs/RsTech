package com.example.tzrstech.controllers;

import com.example.tzrstech.services.dto.ProductDto;
import com.example.tzrstech.services.impl.ProductServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RequestMapping("/products")
public class ProductController {
    private final ProductServiceImpl productService;

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @GetMapping()
    @Tag(name = "Products", description = "Возвращает все продукты из БД")
    public ResponseEntity<List<ProductDto>> allProducts() {
        return ResponseEntity.ok().body(productService.findAll());
    }

    @GetMapping("/{id}")
    @Tag(name = "Get product", description = "Возвращает продукт по заданному id")
    public ResponseEntity<ProductDto> getById(@PathVariable @Valid @Parameter(description = "Идентификатор продукта")
                                              Integer id) {
        return ResponseEntity.ok().body(productService.findByProductId(id));
    }

    @GetMapping("/name/{productName}")
    @Tag(name = "Get by product name", description = "Возвращает продукт по заданному имени")
    public ResponseEntity<List<ProductDto>> getByName(@PathVariable @Valid @Parameter(description = "Название продукта")
                                                      String productName) {
        return ResponseEntity.ok().body(productService.findByProductName(productName));
    }

//    @GetMapping("/name/category/{categoryName}")
//    @Tag(name = "Get by category name", description = "Возвращает продукт относящийся к заданной категории")
//    List<ProductDto> getByCategoryName(@PathVariable @Valid @Parameter(description = "Название категории")
//                                        String categoryName) {
//        return productService.findByCategoryName(categoryName);
//    }

    @GetMapping("/price/{price}")
    @Tag(name = "Get by price", description = "Возвращает продукт(ы) с заданной ценой")
    public ResponseEntity<List<ProductDto>> getByPrice(@PathVariable @Parameter(description = "Стоимость продукта")
                                                       Integer price) {
        return ResponseEntity.ok().body(productService.findByPrice(price));
    }

    @GetMapping("/price/{minPrice}/{maxPrice}")
    @Tag(name = "Get product between min and max price",
            description = "Возвращает продукты попадающие в заданный ценовой диапазон")
    public ResponseEntity<List<ProductDto>> getByPriceBetween(@PathVariable @Parameter(description = "Стоимость от")
                                                              int minPrice,
                                                              @PathVariable @Parameter(description = "Стоимость до")
                                                              int maxPrice) {
        return ResponseEntity.ok().body(productService.findByPriceBetween(minPrice, maxPrice));
    }

    @PostMapping("/new")
    @Tag(name = "Create product", description = "Создает новый продукт")
    public ResponseEntity<ProductDto> create(@RequestBody @Valid @Parameter(description = "Продукт в JSON формате")
                                             ProductDto product) {
        productService.save(product);
        return ResponseEntity.created(URI.create("products/new"))
                .body(product);
    }

    @PostMapping("/category/new")
    @Tag(name = "Create product with new Category", description = "Создает новый продукт и новую категорию")
    public ResponseEntity<ProductDto> createNewProductNewCategory(@RequestBody @Valid @Parameter(description = "Продукт и Категория в JSON формате")
                                                                  ProductDto product) {
        productService.newProductNewCategory(product);
        return ResponseEntity.created(URI.create("products/category/new"))
                .body(product);
    }

    @PutMapping("/{id}")
    @Tag(name = "Update product", description = "Редактирует существующий продукт")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("id") @Valid @Parameter(description = "Идентификатор продукта")
                                                    Integer id,
                                                    @RequestBody @Valid @Parameter(description = "Категория в JSON формате")
                                                    ProductDto updatedProduct) {
        productService.update(id, updatedProduct);
        return ResponseEntity.ok().body(updatedProduct);
    }


    @DeleteMapping("/{id}")
    @Tag(name = "Delete product", description = "Удаляет продукт по заданному id")
    public ResponseEntity<ProductDto> delete(@PathVariable("id") @Valid @Parameter(description = "Идентификатор продукта")
                                             Integer id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
