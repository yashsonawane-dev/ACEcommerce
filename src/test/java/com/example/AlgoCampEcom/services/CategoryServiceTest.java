package com.example.AlgoCampEcom.services;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.entity.Category;
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
}
