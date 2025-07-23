package com.example.AlgoCampEcom.services;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.dto.CategoryWithProductsDTO;
import org.springframework.http.HttpStatusCode;

import java.io.IOException;
import java.util.List;


public interface ICategoryService {
    List<CategoryDTO> getAllCategories() throws IOException;

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO getCategory(Long id) throws Exception;

    CategoryDTO getCategoryByName(String name) throws Exception;

    CategoryWithProductsDTO getCategoryWithProducts(Long id) throws Exception;
}
