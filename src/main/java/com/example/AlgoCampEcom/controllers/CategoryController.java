package com.example.AlgoCampEcom.controllers;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.dto.CategoryWithProductsDTO;
import com.example.AlgoCampEcom.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(@Qualifier("categoryServiceImpl") ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<?> getAllCategories(@RequestParam(required = false) String name) throws Exception {
        if (!ObjectUtils.isEmpty(name)) {
            CategoryDTO categoryDTO = categoryService.getCategoryByName(name);
            return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
        }

        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<CategoryWithProductsDTO> getCategoryWithProducts(@PathVariable Long id) throws Exception{
        CategoryWithProductsDTO dto = categoryService.getCategoryWithProducts(id);
        return ResponseEntity.ok(dto);
    }

}
