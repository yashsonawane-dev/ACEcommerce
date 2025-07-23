package com.example.AlgoCampEcom.gateway;

import com.example.AlgoCampEcom.dto.FakeStoreProductResponseDTO;
import com.example.AlgoCampEcom.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FakeStoreProductGateway implements IProductGateway {

    private final RestTemplate restTemplate;

    @Override
    public ProductDTO getProductById(Long id) {
        // here forward slash is appended before products because RestTemplate treats as a relative path without scheme
        ResponseEntity<FakeStoreProductResponseDTO> response = restTemplate.getForEntity("/products/" + id, FakeStoreProductResponseDTO.class);
        if (!response.getStatusCode().equals(HttpStatus.OK) || ObjectUtils.isEmpty(response.getBody())) {
            return null;
        }

        FakeStoreProductResponseDTO result = response.getBody();
        return result.getProduct();
    }
}
