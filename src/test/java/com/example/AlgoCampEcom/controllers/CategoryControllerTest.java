package com.example.AlgoCampEcom.controllers;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.exception.GlobalExceptionHandler;
import com.example.AlgoCampEcom.services.ICategoryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private ICategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    // It allows you to test your REST endpoints, HTTP requests, response status codes, headers,
    // and JSON content—without running a real HTTP server.
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
                .setControllerAdvice(new GlobalExceptionHandler())
                .build();
    }

    @Test
    void test_getAllCategories_shouldReturnAllCategories() throws Exception {
        List<CategoryDTO> categoryDTOList = new ArrayList<>();
        categoryDTOList.add(CategoryDTO.builder().name("Electronics").id(1L).build());
        categoryDTOList.add(CategoryDTO.builder().name("Footwear").id(2L).build());

        when(categoryService.getAllCategories()).thenReturn(categoryDTOList);

        mockMvc.perform(get("/api/category"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Electronics"));

        verify(categoryService, times(1)).getAllCategories();
    }
}
