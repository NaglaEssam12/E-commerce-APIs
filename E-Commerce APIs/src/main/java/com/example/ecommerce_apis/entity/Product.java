package com.example.ecommerce_apis.entity;


import com.example.ecommerce_apis.model.ProductModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long quantity;
    private Double price = 0.0;
    private boolean active;
    private boolean service;
    private boolean shipped;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public static Product toEntity(ProductModel productModel){
        return Product.builder()
                .id(productModel.getId())
                .name(productModel.getName())
                .quantity(productModel.getQuantity())
                .price(productModel.getPrice())
                .active(productModel.isActive())
                .service(productModel.isService())
                .shipped(productModel.isShipped())
                .category(productModel.getCategory())
                .build();
    }

}
