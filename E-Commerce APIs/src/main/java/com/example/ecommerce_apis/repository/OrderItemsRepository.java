package com.example.ecommerce_apis.repository;

import com.example.ecommerce_apis.entity.Order;
import com.example.ecommerce_apis.entity.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItems, Long> {
    List<OrderItems> findOrderItemsByOrder_Id(Long id);

}
