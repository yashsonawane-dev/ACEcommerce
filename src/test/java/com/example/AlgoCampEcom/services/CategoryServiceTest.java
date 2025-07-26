package com.example.AlgoCampEcom.services;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.entity.Category;
import com.example.AlgoCampEcom.exception.CategoryNotFoundException;
import com.example.AlgoCampEcom.repository.CategoryRepository;
import com.example.AlgoCampEcom.services.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Test
    void test_getAllCategories_shouldReturnAllCategories() throws IOException {
        List<Category> categoryList = new ArrayList<>();
        Category categoryElectronics = Category.builder()
                .name("Electronics")
                .build();
        categoryElectronics.setId(1L);
        Category categoryFootwear = Category.builder()
                .name("Footwear")
                .build();
        categoryFootwear.setId(2L);
        categoryList.add(categoryElectronics);
        categoryList.add(categoryFootwear);

        when(categoryRepository.findAll()).thenReturn(categoryList);

        List<CategoryDTO> result = categoryService.getAllCategories();
        Assertions.assertEquals(2, result.size());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void test_getCategory_shouldReturnCategory() throws Exception {
        Long categoryId = 1L;
        Category category = Category.builder()
                .name("Footwear")
                .build();
        category.setId(1L);

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.of(category));

        CategoryDTO result = categoryService.getCategory(categoryId);

        Assertions.assertEquals("Footwear", result.getName());
    }

    @Test
    void test_getCategory_shouldNotReturnAnyCategory() throws Exception {
        Long categoryId = 1L;

        when(categoryRepository.findById(categoryId)).thenReturn(Optional.empty());

        CategoryNotFoundException categoryNotFoundException = Assertions.assertThrows(CategoryNotFoundException.class, () -> categoryService.getCategory(categoryId));
        Assertions.assertEquals("Category not found with id: 1", categoryNotFoundException.getMessage());
    }
}
