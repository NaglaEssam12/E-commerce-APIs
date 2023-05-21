package com.example.ecommerce_apis.controller;


import com.example.ecommerce_apis.entity.OrderStatus;
import com.example.ecommerce_apis.model.CustomerModel;
import com.example.ecommerce_apis.model.OrderModel;
import com.example.ecommerce_apis.service.CustomerService;
import com.example.ecommerce_apis.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping()
    public OrderModel addOrder(@RequestBody OrderModel orderModel)
    {
        return orderService.addOrder(orderModel);
    }
    @PostMapping("/manage/status")
    public OrderModel manageStatus(@RequestParam Long id, @RequestParam OrderStatus orderStatus){
        return orderService.manageStatus(id,orderStatus);
    }
}
