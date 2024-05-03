package com.example.tzrstech.controllers;

import com.example.tzrstech.services.dto.CategoryDto;
import com.example.tzrstech.services.impl.CategoryServiceImpl;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    @Tag(name = "Categories", description = "Возвращает все категории из БД")
    ResponseEntity<List<CategoryDto>> allCategories() {
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    @Tag(name = "Get categories", description = "Возвращает категорию по заданному id")
    public ResponseEntity<CategoryDto> getById(@PathVariable @Parameter(description = "Идентификатор категории")
                                               Integer id) {
        return ResponseEntity.ok().body(categoryService.findByCategoryId(id));
    }

    @GetMapping("/name/{name}")
    @Tag(name = "Get By category Name", description = "Возвращает категорию по заданному имени")
    public ResponseEntity<List<CategoryDto>> getByName(@PathVariable @Valid @Parameter(description = "Название категории")
                                                       String name) {
        return ResponseEntity.ok().body(categoryService.findByCategoryName(name));
    }

    @PostMapping("/new")
    @Tag(name = "Create category", description = "Создает новую категорию")
    public ResponseEntity<CategoryDto> create(@RequestBody @Valid @Parameter(description = "Категория в JSON формате")
                                              CategoryDto category) {
        categoryService.save(category);
        return ResponseEntity.created(URI.create("category/new"))
                .body(category);
    }

    @PutMapping("/{id}")
    @Tag(name = "Update category", description = "Редактирует существующую категорию")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") @Valid @Parameter(description = "Идентификатор категории")
                                                      Integer id,
                                                      @RequestBody @Valid @Parameter(description = "Категория в JSON формате")
                                                      CategoryDto updatedCategory) {
        categoryService.update(id, updatedCategory);
        return ResponseEntity.ok().body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Delete category", description = "Удаляет категорию по заданному id")
    public ResponseEntity<CategoryDto> delete(@PathVariable("id") @Valid @Parameter(description = "Идентификатор категории")
                                              Integer id) {
        categoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
