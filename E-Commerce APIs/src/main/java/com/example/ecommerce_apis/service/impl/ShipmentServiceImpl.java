package com.example.ecommerce_apis.service.impl;

import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.Shipment;
import com.example.ecommerce_apis.entity.ShipmentStatus;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.OrderModel;
import com.example.ecommerce_apis.model.ShipmentModel;
import com.example.ecommerce_apis.repository.OrderRepository;
import com.example.ecommerce_apis.repository.ShipmentRepository;
import com.example.ecommerce_apis.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShipmentServiceImpl implements ShipmentService {
    @Autowired
    private ShipmentRepository shipmentRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addOrderToShipment(OrderItemsModel orderItemsModel)
    {
        Shipment shipment = shipmentRepository.findShipmentByOrder_Id(orderItemsModel.getOrder().getId());
        Order order = orderRepository.findById(orderItemsModel.getOrder().getId()).orElse(null);
        if(shipment == null){
            shipment = new Shipment();
            shipment.setOrder(order);
            shipmentRepository.save(shipment);
            ShipmentModel shipmentModel = ShipmentModel.toModel(shipment);
        }
    }
    @Override
    public ShipmentModel confirmShipment(Long id) {
        Shipment shipment = shipmentRepository.findById(id).orElse(null);
        if(shipment != null)
        {
            ShipmentModel shipmentModel = ShipmentModel.toModel(shipment);
            shipmentModel.setShipmentStatus(ShipmentStatus.Delivered);
            shipmentRepository.save(Shipment.toEntity(shipmentModel));
            return shipmentModel;
        }
        return null;
    }

    @Override
    public ShipmentModel manageStatus(Long id, ShipmentStatus orderStatus) {
        Shipment shipment = shipmentRepository.findById(id).orElse(null);
        if(shipment != null)
        {
            ShipmentModel shipmentModel = ShipmentModel.toModel(shipment);
            shipmentModel.setShipmentStatus(ShipmentStatus.OrderReceived);
            shipmentRepository.save(Shipment.toEntity(shipmentModel));
            return shipmentModel;
        }
        return null;
    }
}
