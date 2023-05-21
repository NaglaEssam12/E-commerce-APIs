package com.example.ecommerce_apis.service;

import com.example.ecommerce_apis.entity.OrderStatus;
import com.example.ecommerce_apis.entity.Shipment;
import com.example.ecommerce_apis.entity.ShipmentStatus;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.OrderModel;
import com.example.ecommerce_apis.model.ShipmentModel;

public interface ShipmentService {
    void addOrderToShipment(OrderItemsModel orderItemsModel);
    ShipmentModel confirmShipment(Long id);
    ShipmentModel manageStatus(Long id , ShipmentStatus orderStatus);
}
