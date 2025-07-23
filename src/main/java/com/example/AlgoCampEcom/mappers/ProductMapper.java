package com.example.AlgoCampEcom.mappers;


import com.example.AlgoCampEcom.dto.ProductDTO;
import com.example.AlgoCampEcom.dto.ProductWithCategoryDTO;
import com.example.AlgoCampEcom.entity.Category;
import com.example.AlgoCampEcom.entity.Product;

public class ProductMapper {

    public static ProductDTO toDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .categoryId(product.getCategory().getId())
                .brand(product.getBrand())
                .popular(product.getPopular())
                .build();
    }

    public static Product toEntity(ProductDTO productDTO, Category category) {
        return Product.builder()
                .image(productDTO.getImage())
                .color(productDTO.getColor())
                .price(productDTO.getPrice())
                .description(productDTO.getDescription())
                .discount(productDTO.getDiscount())
                .model(productDTO.getModel())
                .title(productDTO.getTitle())
                .category(category)
                .brand(productDTO.getBrand())
                .popular(productDTO.getPopular())
                .build();
    }

    public static ProductWithCategoryDTO toProductWithCategoryDTO(Product product) {
        return ProductWithCategoryDTO.builder()
                .id(product.getId())
                .image(product.getImage())
                .color(product.getColor())
                .price(product.getPrice())
                .description(product.getDescription())
                .discount(product.getDiscount())
                .model(product.getModel())
                .title(product.getTitle())
                .brand(product.getBrand())
                .popular(product.getPopular())
                .category(CategoryMapper.toDTO(product.getCategory()))
                .build();
    }
}
