package com.example.ecommerce_apis.controller;

import com.example.ecommerce_apis.entity.OrderItems;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.service.OrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderItem")
public class OrderItemsController {
    @Autowired
    private OrderItemsService orderItemsService;

    @PostMapping()
    public OrderItemsModel addOrderItem(@RequestBody OrderItemsModel orderItemsModel)
    {
        return orderItemsService.addOrderItem(orderItemsModel);
    }
}
