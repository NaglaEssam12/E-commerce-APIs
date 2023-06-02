package com.example.ecommerce_apis.repository;

import com.example.ecommerce_apis.entity.Shipment;
import com.example.ecommerce_apis.model.ShipmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    Shipment findShipmentByOrder_Id(Long id);
}
