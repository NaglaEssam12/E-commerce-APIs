package com.example.ecommerce_apis.entity;

import com.example.ecommerce_apis.model.OrderItemsModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName = "id")
    private Product product;
    private Long quantity;
    private Double price;
    @ManyToOne
    @JoinColumn(name="order_id", referencedColumnName = "id")
    private Order order;

    public static OrderItems toEntity(OrderItemsModel orderItemsModel){
        return  OrderItems.builder()
                .id(orderItemsModel.getId())
                .name(orderItemsModel.getName())
                .product(orderItemsModel.getProduct())
                .quantity(orderItemsModel.getQuantity())
                .price(orderItemsModel.getPrice())
                .order(orderItemsModel.getOrder())
                .build();
    }


}
