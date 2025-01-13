package com.example.controller.form;

import com.example.entity.Product;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
@Setter
public class EditProductForm {
    private int id;
    private String name;
    private String description;
    private int price;
    private int stock;

    public static EditProductForm from(Product product) {
        return EditProductForm.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }
}
