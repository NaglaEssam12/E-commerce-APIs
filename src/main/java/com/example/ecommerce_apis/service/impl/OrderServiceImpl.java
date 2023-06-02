package com.example.ecommerce_apis.service.impl;

import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.OrderStatus;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.OrderModel;
import com.example.ecommerce_apis.repository.OrderItemsRepository;
import com.example.ecommerce_apis.repository.OrderRepository;
import com.example.ecommerce_apis.service.OrderItemsService;
import com.example.ecommerce_apis.service.OrderService;
import com.example.ecommerce_apis.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemsRepository orderItemsRepository;
//    @Autowired
//    private OrderItemsService orderItemsService;
    @Autowired
    private ShipmentService shipmentService;

    public List<OrderItemsModel> findOrderItemsByOrderId(Long id) {
        return  orderItemsRepository.findOrderItemsByOrder_Id(id)
                .stream()
                .map(orderItem->OrderItemsModel.toModel(orderItem))
                .collect(Collectors.toList());
    }
    @Override
    public OrderModel addOrder(OrderModel orderModel) {
        orderModel.setStatus(OrderStatus.Draft);
        Order order = Order.toEntity(orderModel);
        orderRepository.save(order);
        return OrderModel.toModel(order);
    }
    @Override
    public OrderModel getOrder(Long id)
    {
        Order order = orderRepository.findById(id).orElse(null);
        OrderModel orderModel = OrderModel.toModel(order);
        return orderModel;
    }

    @Override
    public void updateOrderTotalPrice( OrderItemsModel orderItemsModel) {
        OrderModel orderModel = getOrder(orderItemsModel.getOrder().getId());
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

    @Override
    public void finalizeOrder(Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        if(order != null)
        {
            OrderModel orderModel = OrderModel.toModel(order);
            orderModel.setStatus(OrderStatus.Processing);
            orderRepository.save(Order.toEntity(orderModel));
            addOrderToShipment(id);

        }
    }
    @Override
    public void addOrderToShipment(Long id)
    {
//        OrderModel orderModel = getOrder(id);
        List<OrderItemsModel> orderItems = findOrderItemsByOrderId(id);
        for(int i = 0; i < orderItems.size(); i++)
        {
            if(!orderItems.get(i).getProduct().isService())
            {
                shipmentService.addOrderToShipment(id);
                break;
            }
        }

    }

}
