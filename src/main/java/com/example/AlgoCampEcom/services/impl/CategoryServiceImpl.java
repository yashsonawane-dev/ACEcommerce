package com.example.AlgoCampEcom.services.impl;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.dto.CategoryWithProductsDTO;
import com.example.AlgoCampEcom.entity.Category;
import com.example.AlgoCampEcom.exception.CategoryNotFoundException;
import com.example.AlgoCampEcom.mappers.CategoryMapper;
import com.example.AlgoCampEcom.repository.CategoryRepository;
import com.example.AlgoCampEcom.services.ICategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("categoryServiceImpl")
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper::toDTO)
                .toList();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category savedCategory = categoryRepository.save(CategoryMapper.toEntity(categoryDTO));
        return CategoryMapper.toDTO(savedCategory);
    }

    @Override
    public CategoryDTO getCategory(Long id) throws Exception {
        return categoryRepository.findById(id)
                .map(CategoryMapper::toDTO)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
    }

    @Override
    public CategoryDTO getCategoryByName(String name) throws Exception {
        return categoryRepository.findByName(name)
                .map(CategoryMapper::toDTO)
                .orElseThrow(() -> new CategoryNotFoundException("Invalid category name!!!"));
    }

    @Override
    public CategoryWithProductsDTO getCategoryWithProducts(Long id) throws Exception {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category not found with id: " + id));
        return CategoryMapper.toCategoryWithProductsDTO(category);
    }
}
