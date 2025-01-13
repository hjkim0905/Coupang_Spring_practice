package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private int price;
    private int stock;
    private String image;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
