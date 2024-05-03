package com.example.tzrstech.services.mappers;

import com.example.tzrstech.entities.Category;
import com.example.tzrstech.services.dto.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "categoryId", source = "categoryId", ignore = true)
    Category dtoToEntity(CategoryDto categoryDto);

    CategoryDto entityToDto(Category category);

    List<CategoryDto> toListDto(List<Category> categories);
    @Mapping(target = "categoryId", source = "categoryId", ignore = true)
    void updateCategory(CategoryDto updatedCategory, @MappingTarget Category category);
}
