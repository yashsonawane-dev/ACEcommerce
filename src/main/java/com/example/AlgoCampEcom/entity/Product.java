package com.example.AlgoCampEcom.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Product extends BaseEntity {

    private String image;
    private String color;
    private Integer price;
    private String description;
    private Integer discount;
    private String model;
    private String title;
    private String brand;
    private Boolean popular;

    // Many products belongs to one category
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
