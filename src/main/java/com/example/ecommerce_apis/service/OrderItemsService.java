package com.example.ecommerce_apis.service;

import com.example.ecommerce_apis.model.OrderItemsModel;
import org.springframework.stereotype.Service;

import java.util.List;


public interface OrderItemsService {

    OrderItemsModel addOrderItem(OrderItemsModel orderItemsModel);
//    List<OrderItemsModel> findOrderItemsByOrderId(Long id);
}
