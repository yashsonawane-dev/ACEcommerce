package com.example.AlgoCampEcom.mappers;


import com.example.AlgoCampEcom.dto.CategoryDTO;

public class CategoryMappers {

    public static CategoryDTO toCategoryDTO(String name) {
        return CategoryDTO.builder().name(name).build();
    }
}
