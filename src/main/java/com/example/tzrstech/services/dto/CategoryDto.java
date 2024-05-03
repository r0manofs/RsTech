package com.example.tzrstech.services.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CategoryDto {
    @Schema(description = "Идентификатор категории")
    private Integer categoryId;
    @Schema(description = "Название категории")
    private String categoryName;
    @Schema(description = "Описание категории")
    private String description;
}
