package com.example.ecommerce_apis.model;

import com.example.ecommerce_apis.entity.Customer;
import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.OrderStatus;
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
public class OrderModel {

    private Long id;
    private String name;
    private Double totalPrice = 0.0;
    private OrderStatus status;
    private Customer customer;


    public static OrderModel toModel(Order order){
        return  OrderModel.builder()
                .id(order.getId())
                .name(order.getName())
                .totalPrice(order.getTotalPrice())
                .status(order.getStatus())
                .customer(order.getCustomer())
                .build();
    }


}
