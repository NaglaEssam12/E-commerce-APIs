package com.example.ecommerce_apis.entity;

import com.example.ecommerce_apis.model.OrderModel;
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
@Table(name = "`order`")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double totalPrice = 0.0;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    public static Order toEntity(OrderModel orderModel){
        return  Order.builder()
                .id(orderModel.getId())
                .name(orderModel.getName())
                .totalPrice(orderModel.getTotalPrice())
                .status(orderModel.getStatus())
                .customer(orderModel.getCustomer())
                .build();
    }


}
