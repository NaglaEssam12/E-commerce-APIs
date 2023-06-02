package com.example.ecommerce_apis.controller;

import com.example.ecommerce_apis.entity.OrderStatus;
import com.example.ecommerce_apis.entity.ShipmentStatus;
import com.example.ecommerce_apis.model.OrderModel;
import com.example.ecommerce_apis.model.ShipmentModel;
import com.example.ecommerce_apis.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShipmentController {
    @Autowired
    ShipmentService shipmentService;

    @PostMapping("/confirm")
    public ShipmentModel confirmShipment(@RequestParam Long shipmentId)
    {
        return shipmentService.confirmShipment(shipmentId);
    }
    @PostMapping("/manage")
    public ShipmentModel manageStatus(@RequestParam Long id, @RequestParam ShipmentStatus shipmentStatus){
        return shipmentService.manageStatus(id,shipmentStatus);
    }
}
