package com.example.AlgoCampEcom.gateway;

import com.example.AlgoCampEcom.dto.CategoryDTO;
import com.example.AlgoCampEcom.dto.FakeStoreCategoryResponseDTO;
import com.example.AlgoCampEcom.mappers.CategoryMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component("fakeStoreCategoryGatewayRestTemplate")
@RequiredArgsConstructor
public class FakeStoreCategoryGatewayRestTemplate implements ICategoryGateway {

    private final RestTemplate restTemplate;

    @Override
    public List<CategoryDTO> getAllCategories() throws IOException {
        ResponseEntity<FakeStoreCategoryResponseDTO> response = restTemplate.getForEntity("/products/category", FakeStoreCategoryResponseDTO.class);

        if (!response.getStatusCode().equals(HttpStatus.OK) || ObjectUtils.isEmpty(response.getBody())) {
            return Collections.emptyList();
        }

        FakeStoreCategoryResponseDTO body = response.getBody();
        return body.getCategories()
                .stream().map(CategoryMappers::toCategoryDTO)
                .toList();
    }
}
