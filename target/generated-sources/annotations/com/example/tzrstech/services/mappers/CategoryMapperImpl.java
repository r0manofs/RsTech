package com.example.tzrstech.services.mappers;

import com.example.tzrstech.entities.Category;
import com.example.tzrstech.services.dto.CategoryDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-26T14:22:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Category dtoToEntity(CategoryDto categoryDto) {
        if ( categoryDto == null ) {
            return null;
        }

        Category category = new Category();

        category.setCategoryName( categoryDto.getCategoryName() );
        category.setDescription( categoryDto.getDescription() );

        return category;
    }

    @Override
    public CategoryDto entityToDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryDto categoryDto = new CategoryDto();

        categoryDto.setCategoryId( category.getCategoryId() );
        categoryDto.setCategoryName( category.getCategoryName() );
        categoryDto.setDescription( category.getDescription() );

        return categoryDto;
    }

    @Override
    public List<CategoryDto> toListDto(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryDto> list = new ArrayList<CategoryDto>( categories.size() );
        for ( Category category : categories ) {
            list.add( entityToDto( category ) );
        }

        return list;
    }

    @Override
    public void updateCategory(CategoryDto updatedCategory, Category category) {
        if ( updatedCategory == null ) {
            return;
        }

        category.setCategoryName( updatedCategory.getCategoryName() );
        category.setDescription( updatedCategory.getDescription() );
    }
}
