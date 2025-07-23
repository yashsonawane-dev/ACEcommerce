package com.example.AlgoCampEcom.services;

import com.example.AlgoCampEcom.dto.ProductDTO;
import com.example.AlgoCampEcom.dto.ProductWithCategoryDTO;
import com.example.AlgoCampEcom.gateway.IProductGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FakeStoreProductService implements IProductService {

    private final IProductGateway productGateway;

    @Override
    public ProductDTO getProductById(Long id) {
        return productGateway.getProductById(id);
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) throws Exception {
        return null;
    }
}
