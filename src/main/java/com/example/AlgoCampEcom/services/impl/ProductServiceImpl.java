package com.example.AlgoCampEcom.services.impl;

import com.example.AlgoCampEcom.dto.ProductDTO;
import com.example.AlgoCampEcom.dto.ProductWithCategoryDTO;
import com.example.AlgoCampEcom.entity.Category;
import com.example.AlgoCampEcom.entity.Product;
import com.example.AlgoCampEcom.exception.CategoryNotFoundException;
import com.example.AlgoCampEcom.exception.ProductNotFoundException;
import com.example.AlgoCampEcom.mappers.ProductMapper;
import com.example.AlgoCampEcom.repository.CategoryRepository;
import com.example.AlgoCampEcom.repository.ProductRepository;
import com.example.AlgoCampEcom.services.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service("productServiceImpl")
public class ProductServiceImpl implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper::toDTO)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with the id: " + id));
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) throws Exception {
        if (ObjectUtils.isEmpty(productDTO)) {
            throw new RuntimeException("Input data can not empty or null");
        }

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Invalid category"));

        Product savedProduct = productRepository.save(ProductMapper.toEntity(productDTO, category));
        return ProductMapper.toDTO(savedProduct);
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with the id: " + id));
        return ProductMapper.toProductWithCategoryDTO(product);
    }
}
