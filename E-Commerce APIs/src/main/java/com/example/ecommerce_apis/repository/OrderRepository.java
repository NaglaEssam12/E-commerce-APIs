package com.example.ecommerce_apis.repository;

import com.example.ecommerce_apis.entity.Category;
import com.example.ecommerce_apis.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {


}
