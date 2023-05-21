package com.example.ecommerce_apis.service.impl;

import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.OrderStatus;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.OrderModel;
import com.example.ecommerce_apis.repository.OrderRepository;
import com.example.ecommerce_apis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Override
    public OrderModel addOrder(OrderModel orderModel) {
        orderModel.setStatus(OrderStatus.Processing);
        Order order = Order.toEntity(orderModel);
        orderRepository.save(order);
        return OrderModel.toModel(order);
    }

//    @Override
//    public OrderModel updateTotalPrice(OrderModel orderModel) {
//        Order order = orderRepository.findById(orderModel.getId()).orElse(null);
//        if(order != null)
//        {
//            order.setId(orderModel.getId());
//            order.setName(orderModel.getName());
//            order.setTotalPrice(orderModel.getTotalPrice());
//            order.setCustomer(orderModel.getCustomer());
//            order.setStatus(orderModel.getStatus());
//            orderRepository.save(order);
//            return OrderModel.toModel(order);
//        }
//        return null;
//    }

    @Override
    public void updateOrderTotalPrice(OrderItemsModel orderItemsModel) {
        Order order = orderRepository.findById(orderItemsModel.getOrder().getId()).orElse(null);
        OrderModel orderModel = OrderModel.toModel(order);
        Double orderTotalPrice = 0.0;
        orderTotalPrice += orderModel.getTotalPrice();
        orderTotalPrice += orderItemsModel.getPrice();
        if(orderModel != null)
        {
            orderModel.setTotalPrice(orderTotalPrice);
            orderRepository.save(Order.toEntity(orderModel));
        }
    }

    @Override
    public OrderModel manageStatus(Long id, OrderStatus orderStatus) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order != null)
        {
            OrderModel orderModel = OrderModel.toModel(order);
            orderModel.setStatus(orderStatus);
            orderRepository.save(Order.toEntity(orderModel));
            return orderModel;
        }
        return null;
    }

}
