package com.example.AlgoCampEcom.mappers;


import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.dto.CategoryWithProductsDTO;
import com.example.AlgoCampEcom.entity.Category;

public class CategoryMapper {

    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static Category toEntity(CategoryDTO categoryDTO) {
        return Category.builder()
                .name(categoryDTO.getName())
                .build();
    }

    public static CategoryWithProductsDTO toCategoryWithProductsDTO(Category category) {
        return CategoryWithProductsDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .products(category.getProducts().stream()
                        .map(ProductMapper::toDTO)
                        .toList())
                .build();
    }
}
