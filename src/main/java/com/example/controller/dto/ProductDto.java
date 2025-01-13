package com.example.controller.dto;

import com.example.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class ProductDto {
    private int id;
    private String name;
    private String description;
    private int price;
    private int stock;
    private String image;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static ProductDto from(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .image(product.getImage())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
