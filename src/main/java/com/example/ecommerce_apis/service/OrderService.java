package com.example.ecommerce_apis.service;


import com.example.ecommerce_apis.entity.OrderStatus;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.OrderModel;
import org.springframework.stereotype.Service;


public interface OrderService {

    OrderModel addOrder(OrderModel orderModel);
//    OrderModel updateTotalPrice(OrderModel orderModel);
    void updateOrderTotalPrice(OrderItemsModel orderItemsModel);
    OrderModel manageStatus(Long id , OrderStatus orderStatus);
    void  finalizeOrder(Long id);
    void addOrderToShipment(Long id);
    OrderModel getOrder(Long id);
}
