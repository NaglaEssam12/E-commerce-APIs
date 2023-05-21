package com.example.ecommerce_apis.service.impl;

import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.OrderItems;
import com.example.ecommerce_apis.entity.Product;
import com.example.ecommerce_apis.entity.Shipment;
import com.example.ecommerce_apis.model.OrderItemsModel;
import com.example.ecommerce_apis.model.OrderModel;
import com.example.ecommerce_apis.model.ProductModel;
import com.example.ecommerce_apis.model.ShipmentModel;
import com.example.ecommerce_apis.repository.OrderItemsRepository;
import com.example.ecommerce_apis.repository.OrderRepository;
import com.example.ecommerce_apis.repository.ProductRepository;
import com.example.ecommerce_apis.repository.ShipmentRepository;
import com.example.ecommerce_apis.service.OrderItemsService;
import com.example.ecommerce_apis.service.OrderService;
import com.example.ecommerce_apis.service.ProductService;
import com.example.ecommerce_apis.service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemsImpl implements OrderItemsService {
    @Autowired
    private OrderItemsRepository orderItemsRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShipmentService shipmentService;
    @Override
    public List<OrderItemsModel> findOrderItemsByOrderId(Long id) {
        return  orderItemsRepository.findOrderItemsByOrder_Id(id)
                .stream()
                .map(orderItem->OrderItemsModel.toModel(orderItem))
                .collect(Collectors.toList());
    }
    @Override
    public OrderItemsModel addOrderItem(OrderItemsModel orderItemsModel) {

        ProductModel productModel = productService.findProduct(orderItemsModel);
        if(productModel.isActive() && productModel.getQuantity() >= orderItemsModel.getQuantity()) {
            Double productPrice = productService.getProductPrice(orderItemsModel);
            orderItemsModel.setPrice(orderItemsModel.getQuantity() * productPrice);

            orderService.updateOrderTotalPrice(orderItemsModel);
            productService.updateProductQuantity(orderItemsModel);

            OrderItems orderItem = OrderItems.toEntity(orderItemsModel);
            orderItemsRepository.save(orderItem);

            if(!productModel.isService())
                shipmentService.addOrderToShipment(orderItemsModel);
            return OrderItemsModel.toModel(orderItem);
        }
        return null;
    }
    /*
    * Check if quantity is valid before I do a create a new Item ✔
    * check if the product is active or not ✔
    * if the category not active make all its products not active as well and vice verse ✔
    * */

}
