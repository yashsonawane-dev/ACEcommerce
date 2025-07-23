package com.example.AlgoCampEcom.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private String image;
    private String color;
    private Integer price;
    private String description;
    private Integer discount;
    private String model;
    private Long id;
    private String title;
    private Long categoryId;
    private String brand;
    private Boolean popular;
}
