package com.example.ecommerce_apis.model;


import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.entity.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    private Long id;
    private String name;
    private Long quantity;
    private Double price = 0.0;
    private boolean active;
    private boolean service;
    private boolean shipped;
    private Category category;

    public static ProductModel toModel(Product product){
        return ProductModel.builder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .active(product.isActive())
                .service(product.isService())
                .shipped(product.isShipped())
                .category(product.getCategory())
                .build();
    }



}
