package com.example.tzrstech.services.dto;

import com.example.tzrstech.entities.Category;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "Сущность продукта")
public class ProductDto {
    @Schema(description = "Идентификатор продукта")
    private Integer productId;
    @Schema(description = "Название продукта")
    private String productName;
    @Schema(description = "Описание продукта")
    private String description;
    @Schema(description = "Стоимость продукта")
    private Integer price;
    @Schema(description = "Дата поступления продукта в продажу")
    private Date appearenceDate;
    @Schema(description = "Статус продукта(активен/не активен)")
    private boolean status = true;
    @Schema(description = "Категория продукта")
    private Category category;
}
