package com.example.AlgoCampEcom.services;


import com.example.AlgoCampEcom.dto.ProductDTO;
import com.example.AlgoCampEcom.dto.ProductWithCategoryDTO;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    ProductDTO getProductById(Long id);

    ProductDTO createProduct(ProductDTO productDTO) throws Exception;

    ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception;
}
