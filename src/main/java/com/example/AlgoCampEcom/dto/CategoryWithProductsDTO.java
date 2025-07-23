package com.example.AlgoCampEcom.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryWithProductsDTO {
    private Long id;
    private String name;
    private List<ProductDTO> products;
}
