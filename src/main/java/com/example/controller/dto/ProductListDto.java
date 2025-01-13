package com.example.controller.dto;

import com.example.entity.Product;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class ProductListDto {
    private List<ProductDto> productList;

    public static ProductListDto from(List<Product> productList) {
        return ProductListDto.builder()
                .productList(productList.stream()
                        .map(ProductListDto::from)
                        .collect(java.util.stream.Collectors.toList()))
                .build();
    }

    @Builder
    @Getter
    public static class ProductDto {
        private int id;
        private String name;
        private int price;
        private int stock;
        private String image;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    private static ProductDto from(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .image(product.getImage())
                .createdAt(product.getCreatedAt())
                .updatedAt(product.getUpdatedAt())
                .build();
    }
}
