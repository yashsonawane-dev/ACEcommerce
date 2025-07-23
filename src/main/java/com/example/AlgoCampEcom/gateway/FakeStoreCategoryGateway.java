package com.example.AlgoCampEcom.gateway;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.dto.FakeStoreCategoryResponseDTO;
import com.example.AlgoCampEcom.gateway.api.FakeStoreCategoryAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FakeStoreCategoryGateway implements ICategoryGateway {

    private final FakeStoreCategoryAPI fakeStoreCategoryAPI;

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        FakeStoreCategoryResponseDTO response = fakeStoreCategoryAPI.getAllFakeCategories().execute().body();
        if (ObjectUtils.isEmpty(response) || ObjectUtils.isEmpty(response.getCategories())) {
            throw new IOException("Failed to fetch categories from FakeStore API.");
        }

        return response.getCategories()
                .stream().map(category -> CategoryDTO.builder().name(category).build())
                .toList();
    }
}
