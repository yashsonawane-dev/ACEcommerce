package com.example.AlgoCampEcom.services;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.dto.CategoryWithProductsDTO;
import com.example.AlgoCampEcom.gateway.ICategoryGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class FakeStoreCategoryService implements ICategoryService {

    private final ICategoryGateway categoryGateway;

    public FakeStoreCategoryService(@Qualifier("fakeStoreCategoryGatewayRestTemplate") ICategoryGateway categoryGateway) {
        this.categoryGateway = categoryGateway;
    }

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        return categoryGateway.getAllCategories();
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public CategoryDTO getCategory(Long id) {
        return null;
    }

    @Override
    public CategoryDTO getCategoryByName(String name) {
        return null;
    }

    @Override
    public CategoryWithProductsDTO getCategoryWithProducts(Long id) throws Exception {
        return null;
    }
}
