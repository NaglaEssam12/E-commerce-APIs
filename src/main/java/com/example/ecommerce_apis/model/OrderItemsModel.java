package com.example.ecommerce_apis.model;

import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.OrderItems;
import com.example.ecommerce_apis.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsModel {

    private Long id;
    private String name;
    private Product product;
    private Long quantity;
    private Double price;
    private Order order;

    public static OrderItemsModel toModel(OrderItems orderItems){
        return  OrderItemsModel.builder()
                .id(orderItems.getId())
                .name(orderItems.getName())
                .product(orderItems.getProduct())
                .quantity(orderItems.getQuantity())
                .price(orderItems.getPrice())
                .order(orderItems.getOrder())
                .build();
    }

}
